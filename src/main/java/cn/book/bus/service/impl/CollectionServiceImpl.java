package cn.book.bus.service.impl;

import cn.book.bus.domain.FictionCollection;
import cn.book.bus.mapper.CollectionMapper;
import cn.book.bus.service.ICollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 追风
 * @since 2019-12-23
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, FictionCollection> implements ICollectionService {

}
