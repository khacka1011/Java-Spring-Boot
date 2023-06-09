package com.example.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UploadController {

	@RequestMapping( "/form.do" )
	public ModelAndView mail( HttpServletRequest request ) {
		
		// 중복파일 제거
		// 파일명_타임스탬프.확장자
		// System.out.println( System.currentTimeMillis() );
		// System.out.println( System.nanoTime() );
		
		// uuid
		// System.out.println( UUID.randomUUID().toString() );
		
		// session id
		
		// 파일명 / 확장자 분리
		// xxx.jpg / xx.xx.xx.jpg
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "form" );
		return modelAndView;
	}
	
	@RequestMapping( "/form_ok.do" )
	public ModelAndView form_ok( MultipartFile upload ) {
		
		try {
			
			// 파일 업로드

			// 파일명, 확장자 분리
			String extension = upload.getOriginalFilename().substring(
					upload.getOriginalFilename().lastIndexOf( "." ) );
			
			String filename = upload.getOriginalFilename().substring(
					0, upload.getOriginalFilename().lastIndexOf( "." ) );
			
			System.out.println( extension );
			System.out.println( filename );
			
			// 타임스탬프 생성 : 파일명-타임스탬프.확장자
			long timestamp = System.currentTimeMillis();
			
			String newfilename = filename + "-" + timestamp + extension;
			
			upload.transferTo( new File( newfilename ) );
			
		} catch (IllegalStateException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "[에러] " + e.getMessage() );
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "form_ok" );
		return modelAndView;
	}
	
	@RequestMapping( "/form_ok2.do" )
	public ModelAndView form_ok2( MultipartFile upload, HttpServletRequest request ) {
		
		try {
			
			// 데이터도 함께 전송
			
			System.out.println( upload.getOriginalFilename() );
			System.out.println( request.getParameter( "data" ) );
			
			// 파일명, 확장자 분리
			// 파일명-타임스탬프.확장자
			String extension = upload.getOriginalFilename().substring(
					upload.getOriginalFilename().lastIndexOf( "." ) );
			
			String filename = upload.getOriginalFilename().substring(
					0, upload.getOriginalFilename().lastIndexOf( "." ) );
			
			long timestamp = System.currentTimeMillis();
			
			String newfilename = filename + "-" + timestamp + extension;
			
			upload.transferTo( new File( newfilename ) );
			
		} catch (IllegalStateException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "[에러] " + e.getMessage() );
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "form_ok" );
		return modelAndView;
	}
	
	@RequestMapping( "/form_ok3.do" )
	public ModelAndView form_ok3( MultipartFile[] uploads ) {
		
		// System.out.println( uploads.length );
		
		try {
			
			for( MultipartFile upload : uploads ) {
				
				System.out.println( upload.getOriginalFilename() );
				
				String extension = upload.getOriginalFilename().substring(
						upload.getOriginalFilename().lastIndexOf( "." ) );
				
				String filename = upload.getOriginalFilename().substring(
						0, upload.getOriginalFilename().lastIndexOf( "." ) );
				
				long timestamp = System.currentTimeMillis();
				
				String newfilename = filename + "-" + timestamp + extension;
				
				upload.transferTo( new File( newfilename ) );
				
			}
			
		} catch (IllegalStateException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "[에러] " + e.getMessage() );
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "form_ok" );
		return modelAndView;
	}
	
}
