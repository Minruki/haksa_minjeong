package haksa_minjeong.mapper;

import haksa_minjeong.dto.UserPic;

public interface UserPicMapper {
	int insertUserPic(UserPic userPic);
    UserPic getUserPic(int id);
    int deleteUserPic(int id);
}