package org.bond.ghost.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.bond.ghost.utility.ImageZipUtil;
import org.bond.ghost.viewmodel.ShowImageModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/album/showAlbum")
	public ModelAndView showAlbum(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userid") == null) {
			mav.setViewName("/user/toLogin");
		} else {
			String userid = session.getAttribute("userid").toString();
			String sSql = "SELECT g_album.ID,g_album.NAME,g_album.DESC FROM g_album WHERE g_album.userid=?";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sSql, userid);

			mav.setViewName("/album/showAlbum");
			mav.addObject("list", list);
		}

		return mav;
	}

	@RequestMapping(value = "/album/showImage/{id}")
	public ModelAndView showImage(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject obj = null;
		JSONArray array = new JSONArray();

		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

		String sSql = "SELECT ID,AID,FILENAME,FILEPATH FROM g_picture WHERE AID=?";
		SqlRowSet set = jdbcTemplate.queryForRowSet(sSql, id);
		while (set.next()) {
			obj = new JSONObject();
			obj.put("image", basePath + "album/printImage/" + set.getString("ID"));
			obj.put("title", "");
			obj.put("thumb", "");
			obj.put("url", "");
			array.put(obj);
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", array.toString());
		mav.setViewName("/album/showImage");
		return mav;

		// ModelAndView mav = new ModelAndView(new RedirectView(basePath +
		// "album/showImage"));
		// mav.addObject("data", array.toString());
		// return mav;

		// RequestDispatcher rd =
		// request.getRequestDispatcher("/album/showImage");
		// request.setAttribute("data", array.toString());
		// rd.forward(request, response);
		// return null;
	}

	@RequestMapping(value = "/album/toAdd")
	public ModelAndView toAddAlbum() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/album/albumEdit");

		return mav;
	}

	@RequestMapping(value = "/album/toEdit/{id}")
	public ModelAndView toEditAlbum(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/album/albumEdit");
		mav.addObject("albumid", id);
		return mav;
	}

	@RequestMapping(value = "/album/toUpload/{id}")
	public ModelAndView toUploadImage(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView();
		// mav.setViewName("/album/uploadImage");
		// mav.setViewName("/album/uploadTest");
		mav.setViewName("/album/uploadFile");
		mav.addObject("albumid", id);
		return mav;
	}

	@RequestMapping(value = "/album/save")
	public ModelAndView saveAlbum(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userid") == null) {
			try {
				// mav.setViewName("/user/toLogin");
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
				response.sendRedirect(basePath + "user/toLogin");
				return null;
			} catch (Exception ex) {
				mav.setViewName("/album/editFail");
				Logger.getLogger(AlbumController.class).error(ex.getMessage());
			}
		} else {
			try {
				final String id = request.getParameter("id");
				final String userid = session.getAttribute("userid").toString();
				final String name = request.getParameter("name");
				final String desc = request.getParameter("desc");
				final String sSql_i = "insert into g_album(USERID,A_NAME,A_DESC) values(?,?,?)";
				final String sSql_u = "update g_album set A_NAME=?,A_DESC=? where ID=?";

				if (id.length() == 0 || id.equals("0")) {
					KeyHolder keyHolder = new GeneratedKeyHolder();

					int rows = jdbcTemplate.update(new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							// 返回自增值
							PreparedStatement ps = con.prepareStatement(sSql_i, Statement.RETURN_GENERATED_KEYS);
							ps.setLong(1, Long.parseLong(userid));
							ps.setString(2, name);
							ps.setString(3, desc);

							return ps;
						}
					}, keyHolder);

					mav.addObject("albumid", keyHolder.getKey().intValue());
				} else {
					int rows = jdbcTemplate.update(sSql_u, name, desc, id);

					mav.addObject("albumid", id);
				}

				mav.setViewName("/album/editSuccess");
			} catch (Exception ex) {
				mav.addObject("errmsg", ex.getMessage());
				mav.setViewName("/album/editFail");
				Logger.getLogger(AlbumController.class).error(ex.getMessage());
			}
		}

		return mav;
	}

	@RequestMapping(value = "/album/printImage/{id}")
	public void printImage(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
		FileInputStream fis = null;
		response.setContentType("image/jpg");
		try {
			String path = request.getServletContext().getInitParameter("UploadPath");
			String sSql = "SELECT ID,AID,FILENAME,FILEPATH FROM g_picture WHERE ID=?";
			SqlRowSet set = jdbcTemplate.queryForRowSet(sSql, id);
			if (set.next()) {
				OutputStream out = response.getOutputStream();
				File file = new File(path + "/" + set.getString("FILEPATH"));
				fis = new FileInputStream(file);
				byte[] b = new byte[fis.available()];
				fis.read(b);
				out.write(b);
				out.flush();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(AlbumController.class).error(ex.getMessage());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					Logger.getLogger(AlbumController.class).error(ex.getMessage());
				}
			}
		}
	}

	@RequestMapping(value = "/album/upload")
	public ModelAndView uploadImage(HttpServletRequest request, HttpServletResponse response) {
		String albumid = request.getParameter("albumid");
		String path = request.getServletContext().getInitParameter("UploadPath");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());

		// 判断request是否有文件上传
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();

			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS");
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null && file.getSize() > 0) {
					// 原始文件名
					String filePath = file.getOriginalFilename();
					// 索引到最后一个反斜杠
					int start = filePath.lastIndexOf("\\");
					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = filePath.substring(start + 1);

					// 后缀名
					start = filename.indexOf('.');
					String suffixName = filename.substring(start + 1);

					// 日起格式化
					java.util.Date time = Calendar.getInstance().getTime();

					// 相对路径
					String newFileName = format.format(time) + "." + suffixName;
					String relaPath = albumid + "/" + newFileName;
					try {
						ImageZipUtil.resize(file.getInputStream(), path + "/" + relaPath, 1600, 1064, 0.8f);

						String sSql = "insert into g_picture(AID,FILENAME,FILEPATH) values(?,?,?)";
						int rows = jdbcTemplate.update(sSql, albumid, newFileName, relaPath);
					} catch (Exception ex) {
						ex.printStackTrace();
						Logger.getLogger(AlbumController.class).error(ex.getMessage());
					}
				}
			}
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/album/showImage");
		return mav;
	}
}
