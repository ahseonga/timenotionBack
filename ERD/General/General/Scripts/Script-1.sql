-- user 테이블 더미
INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (1, 'John Doe', 'password123', 'johndoe@example.com', 'johnny', TO_DATE('1990-01-01', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (2, 'Jane Smith', 'password456', 'janesmith@example.com', 'jane_s', TO_DATE('1985-05-15', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (3, 'Alice Johnson', 'password789', 'alicej@example.com', 'alicej', TO_DATE('1992-03-22', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (4, 'Bob Brown', 'password321', 'bobbrown@example.com', 'bobbyb', TO_DATE('1988-11-11', 'YYYY-MM-DD'));

INSERT INTO GGHJ_USER (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_NICKNAME, USER_BIRTH) 
VALUES (5, 'Charlie Davis', 'password654', 'charliedavis@example.com', 'charlied', TO_DATE('1995-07-07', 'YYYY-MM-DD'));

-- kakao 더미
INSERT INTO GGHJ_KAKAO (KAKAO_ID, NAME, PROFILE_PIC, PROVIDER, PROVIDER_ID, CREATE_AT, UPDATE_AT, KAKAO_BIRTH)
VALUES (1, '홍길동', 'profile1.jpg', 'Kakao', 'kakao123', SYSDATE, SYSDATE, sysdate);
INSERT INTO GGHJ_KAKAO (KAKAO_ID, NAME, PROFILE_PIC, PROVIDER, PROVIDER_ID, CREATE_AT, UPDATE_AT, KAKAO_BIRTH)
VALUES (2, '김철수', 'profile2.jpg', 'Kakao', 'kakao456', SYSDATE, SYSDATE, sysdate);
INSERT INTO GGHJ_KAKAO (KAKAO_ID, NAME, PROFILE_PIC, PROVIDER, PROVIDER_ID, CREATE_AT, UPDATE_AT, KAKAO_BIRTH)
VALUES (3, '이영희', 'profile3.jpg', 'Kakao', 'kakao789', SYSDATE, SYSDATE, sysdate);
INSERT INTO GGHJ_KAKAO (KAKAO_ID, NAME, PROFILE_PIC, PROVIDER, PROVIDER_ID, CREATE_AT, UPDATE_AT, KAKAO_BIRTH)
VALUES (4, '박민수', 'profile4.jpg', 'Kakao', 'kakao101112', SYSDATE, SYSDATE, sysdate);
INSERT INTO GGHJ_KAKAO (KAKAO_ID, NAME, PROFILE_PIC, PROVIDER, PROVIDER_ID, CREATE_AT, UPDATE_AT, KAKAO_BIRTH)
values(5, '최영호', 'profile5.jpg', 'Kakao', 'kakao131415', SYSDATE, SYSDATE, sysdate);




-- USER_ID와 KAKAO_ID가 존재하는 데이터
INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (1, '일반', '통합 회원 1 설명', 1, NULL);

INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (2, '정지', '통합 회원 2 설명', 2, NULL);

INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (3, '일반', '통합 회원 3 설명', 3, NULL);

INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (4, '탈퇴', '통합 회원 4 설명', 4, NULL);

INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (5, '일반', '통합 회원 5 설명', 5, NULL);

-- KAKAO_ID가 존재하는 데이터
INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (6, '일반', '통합 회원 6 설명', NULL, 1);

INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (7, '정지', '통합 회원 7 설명', NULL, 2);

INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (8, '일반', '통합 회원 8 설명', NULL, 3);

INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (9, '탈퇴', '통합 회원 9 설명', NULL, 4);

INSERT INTO GGHJ_UNI (UNI_ID, UNI_STATUS, UNI_ABOUT, USER_ID, KAKAO_ID)
VALUES (10, '일반', '통합 회원 10 설명', NULL, 5);


-- user_profile 더미
INSERT INTO GGHJ_USER_FILE (
    USER_FILE_ID, 
    USER_FILE_PROFILE_NAME, 
    USER_FILE_PROFILE_SOURCE, 
    USER_FILE_BACK_NAME, 
    USER_FILE_BACK_SOURCE, 
    USER_FILE_PROFILE_UUID, 
    USER_FILE_BACK_UUID, 
    USER_ID
) VALUES (
    1, 
    'profile1.jpg', 
    '/images/profiles/profile1.jpg', 
    'background1.jpg', 
    '/images/backgrounds/background1.jpg', 
    'uuid-profile1', 
    'uuid-background1', 
    1
);

INSERT INTO GGHJ_USER_FILE (
    USER_FILE_ID, 
    USER_FILE_PROFILE_NAME, 
    USER_FILE_PROFILE_SOURCE, 
    USER_FILE_BACK_NAME, 
    USER_FILE_BACK_SOURCE, 
    USER_FILE_PROFILE_UUID, 
    USER_FILE_BACK_UUID, 
    USER_ID
) VALUES (
    2, 
    'profile2.jpg', 
    '/images/profiles/profile2.jpg', 
    'background2.jpg', 
    '/images/backgrounds/background2.jpg', 
    'uuid-profile2', 
    'uuid-background2', 
    2
);

INSERT INTO GGHJ_USER_FILE (
    USER_FILE_ID, 
    USER_FILE_PROFILE_NAME, 
    USER_FILE_PROFILE_SOURCE, 
    USER_FILE_BACK_NAME, 
    USER_FILE_BACK_SOURCE, 
    USER_FILE_PROFILE_UUID, 
    USER_FILE_BACK_UUID, 
    USER_ID
) VALUES (
    3, 
    'profile3.jpg', 
    '/images/profiles/profile3.jpg', 
    'background3.jpg', 
    '/images/backgrounds/background3.jpg', 
    'uuid-profile3', 
    'uuid-background3', 
    3
);

INSERT INTO GGHJ_USER_FILE (
    USER_FILE_ID, 
    USER_FILE_PROFILE_NAME, 
    USER_FILE_PROFILE_SOURCE, 
    USER_FILE_BACK_NAME, 
    USER_FILE_BACK_SOURCE, 
    USER_FILE_PROFILE_UUID, 
    USER_FILE_BACK_UUID, 
    USER_ID
) VALUES (
    4, 
    'profile4.jpg', 
    '/images/profiles/profile4.jpg', 
    'background4.jpg', 
    '/images/backgrounds/background4.jpg', 
    'uuid-profile4', 
    'uuid-background4', 
    4
);

INSERT INTO GGHJ_USER_FILE (
    USER_FILE_ID, 
    USER_FILE_PROFILE_NAME, 
    USER_FILE_PROFILE_SOURCE, 
    USER_FILE_BACK_NAME, 
    USER_FILE_BACK_SOURCE, 
    USER_FILE_PROFILE_UUID, 
    USER_FILE_BACK_UUID, 
    USER_ID
) VALUES (
    5, 
    'profile5.jpg', 
    '/images/profiles/profile5.jpg', 
    'background5.jpg', 
    '/images/backgrounds/background5.jpg', 
    'uuid-profile5', 
    'uuid-background5', 
    5
);

-- follow 더미
INSERT INTO GGHJ_FOLLOW (
    FOLLOW_ID,
    FOLLOW_TO_USER,
    FOLLOW_FROM_USER
) VALUES (
    1,
    2,
    1
);

INSERT INTO GGHJ_FOLLOW (
    FOLLOW_ID,
    FOLLOW_TO_USER,
    FOLLOW_FROM_USER
) VALUES (
    2,
    1,
    2
);

INSERT INTO GGHJ_FOLLOW (
    FOLLOW_ID,
    FOLLOW_TO_USER,
    FOLLOW_FROM_USER
) VALUES (
    3,
    4,
    2
);

INSERT INTO GGHJ_FOLLOW (
    FOLLOW_ID,
    FOLLOW_TO_USER,
    FOLLOW_FROM_USER
) VALUES (
    4,
    5,
    3
);

INSERT INTO GGHJ_FOLLOW (
    FOLLOW_ID,
    FOLLOW_TO_USER,
    FOLLOW_FROM_USER
) VALUES (
    5,
    1,
    4
);

-- board 더미
-- 첫 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    1,
    '게시물 1 제목',
    '게시물 1 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    10,
    '청소년기',
    5,
    '2024',
    1
);

-- 두 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    2,
    '게시물 2 제목',
    '게시물 2 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    20,
    '청소년기',
    10,
    '2024',
    2
);

-- 세 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    3,
    '게시물 3 제목',
    '게시물 3 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    30,
    '청소년기',
    15,
    '2024',
    3
);

-- 네 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    4,
    '게시물 4 제목',
    '게시물 4 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    40,
    '청소년기',
    20,
    '2024',
    4
);

-- 다섯 번째 더미 데이터
INSERT INTO GGHJ_BOARD (
    BOARD_ID,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_PUBLIC,
    BOARD_CREATED_DATE,
    BOARD_UPDATED_DATE,
    BOARD_VIEW_COUNT,
    BOARD_LIFE_CYCLE,
    BOARD_LIKE_COUNT,
    BOARD_YEAR,
    USER_ID
) VALUES (
    5,
    '게시물 5 제목',
    '게시물 5 내용입니다.',
    'O',
    SYSDATE,
    SYSDATE,
    50,
    '청소년기',
    25,
    '2024',
    5
);

-- board_file 더미

-- 첫 번째 더미 데이터
INSERT INTO GGHJ_BOARD_FILE (
    BOARD_FILE_ID,
    BOARD_FILE_NAME,
    BOARD_FILE_SOURCE_NAME,
    BOARD_FILE_UUID,
    BOARD_ID
) VALUES (
    1,
    '사진1.jpg',
    '/path/to/image1.jpg',
    'uuid1',
    1
);

-- 두 번째 더미 데이터
INSERT INTO GGHJ_BOARD_FILE (
    BOARD_FILE_ID,
    BOARD_FILE_NAME,
    BOARD_FILE_SOURCE_NAME,
    BOARD_FILE_UUID,
    BOARD_ID
) VALUES (
    2,
    '사진2.jpg',
    '/path/to/image2.jpg',
    'uuid2',
    2
);

-- 세 번째 더미 데이터
INSERT INTO GGHJ_BOARD_FILE (
    BOARD_FILE_ID,
    BOARD_FILE_NAME,
    BOARD_FILE_SOURCE_NAME,
    BOARD_FILE_UUID,
    BOARD_ID
) VALUES (
    3,
    '사진3.jpg',
    '/path/to/image3.jpg',
    'uuid3',
    3
);

-- 네 번째 더미 데이터
INSERT INTO GGHJ_BOARD_FILE (
    BOARD_FILE_ID,
    BOARD_FILE_NAME,
    BOARD_FILE_SOURCE_NAME,
    BOARD_FILE_UUID,
    BOARD_ID
) VALUES (
    4,
    '사진4.jpg',
    '/path/to/image4.jpg',
    'uuid4',
    4
);

-- 다섯 번째 더미 데이터
INSERT INTO GGHJ_BOARD_FILE (
    BOARD_FILE_ID,
    BOARD_FILE_NAME,
    BOARD_FILE_SOURCE_NAME,
    BOARD_FILE_UUID,
    BOARD_ID
) VALUES (
    5,
    '사진5.jpg',
    '/path/to/image5.jpg',
    'uuid5',
    5
);

-- Like 더미
-- 첫 번째 더미 데이터
INSERT INTO GGHJ_LIKE (
    LIKE_ID,
    BOARD_ID,
    USER_ID,
    LIKE_CREATED_DATE
) VALUES (
    1,
    1,
    1,
    SYSDATE
);

-- 두 번째 더미 데이터
INSERT INTO GGHJ_LIKE (
    LIKE_ID,
    BOARD_ID,
    USER_ID,
    LIKE_CREATED_DATE
) VALUES (
    2,
    2,
    2,
    SYSDATE
);

-- 세 번째 더미 데이터
INSERT INTO GGHJ_LIKE (
    LIKE_ID,
    BOARD_ID,
    USER_ID,
    LIKE_CREATED_DATE
) VALUES (
    3,
    3,
    3,
    SYSDATE
);

-- 네 번째 더미 데이터
INSERT INTO GGHJ_LIKE (
    LIKE_ID,
    BOARD_ID,
    USER_ID,
    LIKE_CREATED_DATE
) VALUES (
    4,
    4,
    4,
    SYSDATE
);

-- 다섯 번째 더미 데이터
INSERT INTO GGHJ_LIKE (
    LIKE_ID,
    BOARD_ID,
    USER_ID,
    LIKE_CREATED_DATE
) VALUES (
    5,
    5,
    5,
    SYSDATE
);

-- comment 더미 
-- 첫 번째 더미 데이터
INSERT INTO GGHJ_COMMENT (
    COMMENT_ID,
    COMMENT_CONTENT,
    COMMENT_CREATED_DATE,
    BOARD_ID,
    USER_ID
) VALUES (
    1,
    '첫 번째 댓글입니다.',
    SYSDATE,
    1,
    1
);

-- 두 번째 더미 데이터
INSERT INTO GGHJ_COMMENT (
    COMMENT_ID,
    COMMENT_CONTENT,
    COMMENT_CREATED_DATE,
    BOARD_ID,
    USER_ID
) VALUES (
    2,
    '두 번째 댓글입니다.',
    SYSDATE,
    2,
    2
);

-- 세 번째 더미 데이터
INSERT INTO GGHJ_COMMENT (
    COMMENT_ID,
    COMMENT_CONTENT,
    COMMENT_CREATED_DATE,
    BOARD_ID,
    USER_ID
) VALUES (
    3,
    '세 번째 댓글입니다.',
    SYSDATE,
    3,
    3
);

-- 네 번째 더미 데이터
INSERT INTO GGHJ_COMMENT (
    COMMENT_ID,
    COMMENT_CONTENT,
    COMMENT_CREATED_DATE,
    BOARD_ID,
    USER_ID
) VALUES (
    4,
    '네 번째 댓글입니다.',
    SYSDATE,
    4,
    4
);

-- 다섯 번째 더미 데이터
INSERT INTO GGHJ_COMMENT (
    COMMENT_ID,
    COMMENT_CONTENT,
    COMMENT_CREATED_DATE,
    BOARD_ID,
    USER_ID
) VALUES (
    5,
    '다섯 번째 댓글입니다.',
    SYSDATE,
    5,
    5
);

-- reply 더미
-- 첫 번째 댓글에 대한 답글 더미 데이터
INSERT INTO GGHJ_REPLY (
    REPLY_ID,
    REPLY_CONTENT,
    REPLY_CREATED_DATE,
    COMMENT_ID
) VALUES (
    1,
    '첫 번째 댓글에 대한 답글입니다.',
    SYSDATE,
    1
);

-- 두 번째 댓글에 대한 답글 더미 데이터
INSERT INTO GGHJ_REPLY (
    REPLY_ID,
    REPLY_CONTENT,
    REPLY_CREATED_DATE,
    COMMENT_ID
) VALUES (
    2,
    '두 번째 댓글에 대한 답글입니다.',
    SYSDATE,
    2
);

-- 세 번째 댓글에 대한 답글 더미 데이터
INSERT INTO GGHJ_REPLY (
    REPLY_ID,
    REPLY_CONTENT,
    REPLY_CREATED_DATE,
    COMMENT_ID
) VALUES (
    3,
    '세 번째 댓글에 대한 답글입니다.',
    SYSDATE,
    3
);

-- 네 번째 댓글에 대한 답글 더미 데이터
INSERT INTO GGHJ_REPLY (
    REPLY_ID,
    REPLY_CONTENT,
    REPLY_CREATED_DATE,
    COMMENT_ID
) VALUES (
    4,
    '네 번째 댓글에 대한 답글입니다.',
    SYSDATE,
    4
);

-- 다섯 번째 댓글에 대한 답글 더미 데이터
INSERT INTO GGHJ_REPLY (
    REPLY_ID,
    REPLY_CONTENT,
    REPLY_CREATED_DATE,
    COMMENT_ID
) VALUES (
    5,
    '다섯 번째 댓글에 대한 답글입니다.',
    SYSDATE,
    5
);

-- report 더미

-- 첫 번째 신고 데이터
INSERT INTO GGHJ_REPORT (
    REPORT_ID,
    REPORT_REASON,
    REPORT_CREATED_DATE,
    REPORT_COUNT,
    USER_ID,
    REPLY_ID,
    COMMENT_ID
) VALUES (
    1,
    '스팸 댓글입니다.',
    SYSDATE,
    1,
    1,  -- 사용자 ID
    NULL, -- 답글 ID
    1  -- 댓글 ID
);

-- 두 번째 신고 데이터
INSERT INTO GGHJ_REPORT (
    REPORT_ID,
    REPORT_REASON,
    REPORT_CREATED_DATE,
    REPORT_COUNT,
    USER_ID,
    REPLY_ID,
    COMMENT_ID
) VALUES (
    2,
    '욕설이 포함된 댓글입니다.',
    SYSDATE,
    1,
    2,  -- 사용자 ID
    NULL, -- 답글 ID
    2  -- 댓글 ID
);

-- 세 번째 신고 데이터
INSERT INTO GGHJ_REPORT (
    REPORT_ID,
    REPORT_REASON,
    REPORT_CREATED_DATE,
    REPORT_COUNT,
    USER_ID,
    REPLY_ID,
    COMMENT_ID
) VALUES (
    3,
    '욕설이 포함된 답글입니다.',
    SYSDATE,
    1,
    3,  -- 사용자 ID
    1,  -- 답글 ID
    NULL  -- 댓글 ID
);

-- inquiry 더미

-- 첫 번째 문의 데이터
INSERT INTO GGHJ_INQUIRY (
    INQUIRY_ID,
    INQUIRY_TITLE,
    INQUIRY_CONTENT,
    INQUIRY_RESPONSE,
    INQUIRY_CREATED_DATE,
    INQUIRY_PUBLIC,
    USER_ID
) VALUES (
    1,
    '회원가입 문의',
    '회원가입이 안되는데 어떻게 해야 하나요?',
    NULL,
    SYSDATE,
    'O',
    1  -- 사용자 ID
);

-- 두 번째 문의 데이터
INSERT INTO GGHJ_INQUIRY (
    INQUIRY_ID,
    INQUIRY_TITLE,
    INQUIRY_CONTENT,
    INQUIRY_RESPONSE,
    INQUIRY_CREATED_DATE,
    INQUIRY_PUBLIC,
    USER_ID
) VALUES (
    2,
    '게시글 작성 문의',
    '게시글을 작성하려는데 어떻게 해야 하나요?',
    NULL,
    SYSDATE,
    'O',
    2  -- 사용자 ID
);

-- 세 번째 문의 데이터
INSERT INTO GGHJ_INQUIRY (
    INQUIRY_ID,
    INQUIRY_TITLE,
    INQUIRY_CONTENT,
    INQUIRY_RESPONSE,
    INQUIRY_CREATED_DATE,
    INQUIRY_PUBLIC,
    USER_ID
) VALUES (
    3,
    '로그인 오류 문의',
    '로그인이 안되는데 어떻게 해결해야 하나요?',
    NULL,
    SYSDATE,
    'O',
    3  -- 사용자 ID
);

-- notification 더미

-- 첫 번째 공지 데이터
INSERT INTO GGHJ_NOTICE (
    NOTICE_ID,
    NOTICE_TITLE,
    NOTICE_CONTENT,
    NOTICE_CREATED_DATE,
    USER_ID
) VALUES (
    1,
    '서비스 이용 안내',
    '본 서비스를 이용해 주셔서 감사합니다. 이용 중 궁금한 사항이 있으시면 언제든지 문의해 주세요.',
    SYSDATE,
    1  -- 관리자(유저) ID
);

-- 두 번째 공지 데이터
INSERT INTO GGHJ_NOTICE (
    NOTICE_ID,
    NOTICE_TITLE,
    NOTICE_CONTENT,
    NOTICE_CREATED_DATE,
    USER_ID
) VALUES (
    2,
    '서비스 업데이트 안내',
    '서비스 업데이트로 인해 일시적인 서비스 중단이 있을 예정입니다. 양해 부탁드립니다.',
    SYSDATE,
    1  -- 관리자(유저) ID
);

-- 세 번째 공지 데이터
INSERT INTO GGHJ_NOTICE (
    NOTICE_ID,
    NOTICE_TITLE,
    NOTICE_CONTENT,
    NOTICE_CREATED_DATE,
    USER_ID
) VALUES (
    3,
    '서비스 장애 안내',
    '현재 서비스에 장애가 발생하고 있습니다. 빠른 시일 내에 해결하도록 노력하겠습니다.',
    SYSDATE,
    1  -- 관리자(유저) ID
);

-- banner 더미

-- 첫 번째 배너 데이터
INSERT INTO GGHJ_BANNER (
    BANNER_ID,
    BANNER_NAME,
    BANNER_SOURCE,
    BANNER_UUID,
    USER_ID
) VALUES (
    1,
    '배너1',
    '/images/banner/banner1.jpg',
    'banner1_uuid',
    1  -- 배너를 등록한 유저의 ID
);

-- 두 번째 배너 데이터
INSERT INTO GGHJ_BANNER (
    BANNER_ID,
    BANNER_NAME,
    BANNER_SOURCE,
    BANNER_UUID,
    USER_ID
) VALUES (
    2,
    '배너2',
    '/images/banner/banner2.jpg',
    'banner2_uuid',
    1  -- 배너를 등록한 유저의 ID
);

-- 세 번째 배너 데이터
INSERT INTO GGHJ_BANNER (
    BANNER_ID,
    BANNER_NAME,
    BANNER_SOURCE,
    BANNER_UUID,
    USER_ID
) VALUES (
    3,
    '배너3',
    '/images/banner/banner3.jpg',
    'banner3_uuid',
    2  -- 배너를 등록한 유저의 ID
);


-- keyword 더미
-- 20개의 더미 키워드 데이터 삽입
-- 20개의 더미 키워드 데이터 중복 허용하여 삽입
BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO GGHJ_KEYWORD (KEYWORD_ID, KEYWORD_CONTENT, KEYWORD_TIME_STAMP)
        VALUES (i, CASE WHEN MOD(i, 5) = 0 THEN 'keyword1' ELSE 'keyword' || TO_CHAR(i) END, SYSDATE);
    END LOOP;
    COMMIT;
END;

SELECT keyword_content, keyword_count
FROM (
    SELECT keyword_content, COUNT(*) AS keyword_count
    FROM gghj_keyword
    GROUP BY keyword_content
) subquery
ORDER BY keyword_count DESC;

SELECT * FROM gghj_keyword;







