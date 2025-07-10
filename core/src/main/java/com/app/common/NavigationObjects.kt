package com.app.common

sealed class NavigationObjects (val nav:String){
    object splash: NavigationObjects("splash")
    object UserList : NavigationObjects("list")
    object Details :NavigationObjects("details")
}