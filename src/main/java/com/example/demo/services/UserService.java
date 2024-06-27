package com.example.demo.services;
import com.example.demo.mapers.UserMappers;
import com.example.demo.mapers.UserProductsMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import com.example.demo.repositories.IUserProductsRepository;
import com.example.demo.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    private final IUserProductsRepository userProductsRepository;


    @Override
    public List<UserModel> findAll() {
        return UserMappers.toModelList(userRepository.findAll());
    }

    @Override
    public UserPageModel findPagedList(PageRequest pageRequest) {
        return UserMappers.toModelPagedList(userRepository.findAll(pageRequest));
    }

    @Override
    public UserModel create(UserModel model) {
        var entity = UserMappers.toEntity(model);

        var result = userRepository.save(entity);

        return UserMappers.toModel(result);
    }

    @Override
    public List<UserProductsModel> findUserProductsAll() {
        var result = userProductsRepository.findAll();

        return UserProductsMapper.toModelList(result);
    }

}
