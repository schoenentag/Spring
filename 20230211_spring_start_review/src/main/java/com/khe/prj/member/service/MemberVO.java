package com.khe.prj.member.service;

import lombok.Data;

@Data
public class MemberVO {
	
    private String memberId; 
    private String memberPassword;
    private String memberName;
    private String memberAuthor;
}
