package com.sample.presentation.viewmodel;

import com.app.domain.usecase.GetUserListUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class UserListViewModel_Factory implements Factory<UserListViewModel> {
  private final Provider<GetUserListUseCase> getUserListUseCaseProvider;

  public UserListViewModel_Factory(Provider<GetUserListUseCase> getUserListUseCaseProvider) {
    this.getUserListUseCaseProvider = getUserListUseCaseProvider;
  }

  @Override
  public UserListViewModel get() {
    return newInstance(getUserListUseCaseProvider.get());
  }

  public static UserListViewModel_Factory create(
      Provider<GetUserListUseCase> getUserListUseCaseProvider) {
    return new UserListViewModel_Factory(getUserListUseCaseProvider);
  }

  public static UserListViewModel newInstance(GetUserListUseCase getUserListUseCase) {
    return new UserListViewModel(getUserListUseCase);
  }
}
