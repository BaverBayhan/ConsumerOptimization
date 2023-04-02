import 'package:flutter/material.dart';
import 'package:gdsc_project/models/user_info_model.dart';
import 'package:gdsc_project/models/user_request_model.dart';
import 'package:gdsc_project/register/registered_user_info.dart';
import '../models/user_response_model.dart';
import './register.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:gdsc_project/cache/cache_manager.dart';

abstract class RegisterViewModel extends State<Register> with CacheManager {
  Future<bool> register(UserRequestModel model) async {
    // ignore: constant_identifier_names
    const String loginUrl = 'http://localhost:8080/api/auth/register';

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

  void navigatetoInfo() {
    Navigator.of(context)
        .push(MaterialPageRoute(builder: (context) => RegisteredUserInfo()));
  }

  void showSnackBar(BuildContext context) {
    const snackBar = SnackBar(
      content: Text('Please fill the required blanks correctly!'),
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }

  Color? primColor() => Colors.grey[300];
}
