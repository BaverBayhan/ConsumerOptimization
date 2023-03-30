import 'package:flutter/material.dart';
import 'package:gdsc_project/home/const_nav_bar.dart';
import 'package:gdsc_project/home/home.dart';
import 'package:gdsc_project/models/user_request_model.dart';
import 'package:gdsc_project/models/user_response_model.dart';
import './login.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:gdsc_project/cache/cache_manager.dart';

abstract class LoginViewModel extends State<Login> with CacheManager {
  Future<bool> login(UserRequestModel model) async {
    // ignore: constant_identifier_names
    const String loginUrl = 'http://localhost:8080/api/auth/login';
    final response = await http.post(Uri.parse(loginUrl),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode({
          'username': model.username.toString(),
          'password': model.password.toString()
        }));
    if (response.statusCode == 200) {
      String? token =
          UserResponseModel.fromJson(json.decode(response.body)).accessToken;
      saveToken(token ?? '');
      return true;
    } else {
      return false;
    }
  }

  Color? primColor() => Colors.grey[300];

  void navigatetoHome() {
    Navigator.pushReplacement(
        context, MaterialPageRoute(builder: (context) => ConstNavBar()));
  }

  void showSnackBar(BuildContext context) {
    const snackBar = SnackBar(
      content: Text('Please fill the required blanks correctly!'),
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }
}
