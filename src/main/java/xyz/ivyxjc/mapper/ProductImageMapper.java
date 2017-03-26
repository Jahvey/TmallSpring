package xyz.ivyxjc.mapper;

import xyz.ivyxjc.bean.ProductImage;
import xyz.ivyxjc.utils.DataOffsetSetting;

import java.util.List;

/**
 * Created by jc on 3/24/2017.
 */


public interface ProductImageMapper extends BaseMapper<ProductImage> {


    default ProductImage getFirstImageBypid(int id){
        return getImagesBypid(id).get(0);
    }

    List<ProductImage> getImagesBypid(int id);

    List<ProductImage> getSingleImagesBypid(int id);

    List<ProductImage> getDetailImagesBypid(int id);
}
