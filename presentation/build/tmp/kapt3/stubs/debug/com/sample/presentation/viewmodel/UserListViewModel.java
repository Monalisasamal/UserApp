package com.sample.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/sample/presentation/viewmodel/UserListViewModel;", "Landroidx/lifecycle/ViewModel;", "getUserListUseCase", "Lcom/app/domain/usecase/GetUserListUseCase;", "(Lcom/app/domain/usecase/GetUserListUseCase;)V", "_selectedUser", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/app/domain/model/UserItem;", "_userList", "Lcom/app/common/Resource;", "", "selectedUser", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedUser", "()Lkotlinx/coroutines/flow/StateFlow;", "userList", "getUserList", "fetchUserList", "", "setSelectedUser", "user", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class UserListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.app.domain.usecase.GetUserListUseCase getUserListUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.app.common.Resource<java.util.List<com.app.domain.model.UserItem>>> _userList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.app.common.Resource<java.util.List<com.app.domain.model.UserItem>>> userList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.app.domain.model.UserItem> _selectedUser = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.app.domain.model.UserItem> selectedUser = null;
    
    @javax.inject.Inject()
    public UserListViewModel(@org.jetbrains.annotations.NotNull()
    com.app.domain.usecase.GetUserListUseCase getUserListUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.app.common.Resource<java.util.List<com.app.domain.model.UserItem>>> getUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.app.domain.model.UserItem> getSelectedUser() {
        return null;
    }
    
    public final void fetchUserList() {
    }
    
    public final void setSelectedUser(@org.jetbrains.annotations.NotNull()
    com.app.domain.model.UserItem user) {
    }
}