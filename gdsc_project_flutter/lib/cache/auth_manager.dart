import 'package:flutter/widgets.dart';
import 'package:flutter/material.dart';
import 'package:gdsc_project/cache/cache_manager.dart';

class AuthanticationManager extends CacheManager {
  BuildContext context;
  AuthanticationManager({required this.context}) {
    fetchUserLogin();
  }

  bool isLogin = false;

  Future<void> fetchUserLogin() async {
    final token = await getToken();
    if (token != null || token != '') {
      isLogin = true;
    }
  }

  Future<void> deleteUserLogin() async {
    await deleteToken();
    isLogin:
    false;
  }
}
