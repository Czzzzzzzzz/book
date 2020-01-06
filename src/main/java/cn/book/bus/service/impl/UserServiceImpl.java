package cn.book.bus.service.impl;

import cn.book.bus.domain.User;
import cn.book.bus.mapper.UserMapper;
import cn.book.bus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 追风
 * @since 2019-12-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
