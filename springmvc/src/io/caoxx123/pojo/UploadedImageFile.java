package io.caoxx123.pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {
	MultipartFile image;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
