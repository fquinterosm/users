package com.bci.users.infraestructure.controller;

import com.bci.users.api.CustomValidationApi;
import com.bci.users.api.model.ApiCustomValidation;
import com.bci.users.api.model.ApiCustomValidationsResponse;
import com.bci.users.domain.port.input.customValidation.GetAllCustomValidationRepositoryUseCase;
import com.bci.users.domain.port.input.customValidation.SaveOrUpdateCustomValidationRepositoryUseCase;
import com.bci.users.infraestructure.controller.mapper.IMapperToModel;
import com.bci.users.infraestructure.controller.mapper.IMapperToResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomValidationController implements CustomValidationApi {


    private final GetAllCustomValidationRepositoryUseCase getAllCustomValidationRepositoryUseCase;
    private final SaveOrUpdateCustomValidationRepositoryUseCase saveOrUpdateCustomValidationRepositoryUseCase;
    private final IMapperToResponse mapperToResponse;
    private final IMapperToModel mapperToModel;

    public CustomValidationController(GetAllCustomValidationRepositoryUseCase getAllCustomValidationRepositoryUseCase,
                                      SaveOrUpdateCustomValidationRepositoryUseCase saveOrUpdateCustomValidationRepositoryUseCase,
                                      IMapperToResponse mapperToResponse,
                                      IMapperToModel mapperToModel) {
        this.getAllCustomValidationRepositoryUseCase = getAllCustomValidationRepositoryUseCase;
        this.saveOrUpdateCustomValidationRepositoryUseCase = saveOrUpdateCustomValidationRepositoryUseCase;
        this.mapperToResponse = mapperToResponse;
        this.mapperToModel = mapperToModel;
    }


    @Override
    public ResponseEntity<ApiCustomValidation> customValidation(ApiCustomValidation customValidation) {
        return ResponseEntity.ok(mapperToResponse.mapperCustomValidation(saveOrUpdateCustomValidationRepositoryUseCase
            .saveOrUpdate(mapperToModel.mapperCustomValidation(customValidation))));
    }

    @Override
    public ResponseEntity<ApiCustomValidationsResponse> getCustomValidations() {
        return ResponseEntity.ok(mapperToResponse.mapperCustomValidationList(getAllCustomValidationRepositoryUseCase.execute()));
    }
}
