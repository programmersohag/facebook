package com.sk.sheikhpura.dao.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageTest {

	public static void main(String[] args) {

		try {

			byte[] imageInByte;
			BufferedImage originalImage = ImageIO.read(new File(
					"D:/darksouls.jpg"));

			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
			System.out.println(imageInByte);

			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);

			ImageIO.write(bImageFromConvert, "jpg", new File(
					"D:/new-darksouls.jpg"));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
