package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: tk.mybatis.mapper
 * @ClassName: MyMapper
 * @Author: break
 * @Description:
 * @Date: 2019/7/17 0017 下午 18:58
 * @Version: 1.0
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
