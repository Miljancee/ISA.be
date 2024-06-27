package com.example.demo.services;
import java.util.List;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import org.springframework.data.domain.PageRequest;


public interface IUserService {

    List<UserModel> findAll();

    UserPageModel findPagedList(PageRequest pageRequest);

    UserModel create(UserModel model);
    UserModel update (UserModel model);

    List<UserProductsModel> findUserProductsAll();
}
