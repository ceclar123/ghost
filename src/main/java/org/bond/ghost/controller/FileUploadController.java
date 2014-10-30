package org.bond.ghost.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import org.bond.ghost.entity.UploadFileEntity;

@Controller
public class FileUploadController {
	@RequestMapping(value = "/module/fileUpload")
	public String fileUpload(HttpServletRequest request,
			HttpServletResponse response) {
		UploadFileEntity fileEntity = null;
		List<UploadFileEntity> uploadFile = new ArrayList<UploadFileEntity>();

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getServletContext());

		// 判断request是否有文件上传
		if (multipartResolver.isMultipart(request)) {
			String path = request.getServletContext().getInitParameter(
					"UploadPath");
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null && file.getSize() > 0) {
					String filePath = file.getOriginalFilename();
					// 索引到最后一个反斜杠
					int start = filePath.lastIndexOf("\\");
					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = filePath.substring(start + 1);

					fileEntity = new UploadFileEntity(filePath, filename,
							file.getSize(), "OK");

					try {
						File localFile = new File(path + "\\" + filename);

						// 将上传文件写到服务器上指定的文件
						file.transferTo(localFile);
					} catch (Exception ex) {
						fileEntity.setMessage(ex.getMessage());
						ex.printStackTrace();
					} finally {
						uploadFile.add(fileEntity);
					}
				}
			}
		}

		request.setAttribute("result", uploadFile);
		return "fileUploadResult";
	}
}
