package com.user.vo;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserRequest() {

	public static record SignUp(

			@NotEmpty(message = "이메일은 필수 입력값입니다.") 
			@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.") 
			String email,

			@NotEmpty(message = "비밀번호는 필수 입력값입니다.") 
			@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자가 사용되어야 합니다.") 
			String password,

			@NotEmpty(message = "이름은 필수 입력값입니다.") String name,

			@NotNull(message = "시 도 주소는 필수 입력값입니다.") Integer sidoCode,

			@NotNull(message = "군 구 주소는 필수 입력값입니다.") Integer gunguCode) {

	}

	public static record Login(

			@NotEmpty(message = "이메일은 필수 입력값입니다.") 
			@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.") 
			String email,

			@NotEmpty(message = "비밀번호는 필수 입력값입니다.") String password) {

		public UsernamePasswordAuthenticationToken toAuthentication() {
			return new UsernamePasswordAuthenticationToken(email, password);
		}
	}

	public static record Reissue(

			@NotEmpty(message = "accessToken은 필수 값입니다.") 
			String accessToken,

			@NotEmpty(message = "refreshToken은 필수 값입니다.")
			String refreshToken) {

	}

	public static record Logout(

			@NotEmpty(message = "잘못된 요청입니다.") 
			String accessToken,

			@NotEmpty(message = "잘못된 요청입니다.") 
			String refreshToken) {

	}
}
