import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:gdsc_project/cache/cache_manager.dart';
import 'package:gdsc_project/models/user_info_model.dart';
import '../models/feed_model.dart';
import './profile.dart';
import 'package:http/http.dart' as http;

abstract class ProfileViewModel extends State<Profile> with CacheManager {
  Future<UserInfoModel?> getUserInfo() async {
    String? token = await getToken() ?? '';
    const String infoUrl = "http://localhost:8080/api/userinfo/retrieve";
    final response = await http
        .get(Uri.parse(infoUrl), headers: {'Authorization': 'Bearer $token'});
    if (response.statusCode == 200) {
      return UserInfoModel.fromJson(jsonDecode(response.body));
    }
    return null;
  }

  Future<List?> getUserPosts() async {
    String? token = await getToken() ?? '';
    const String postUrl = 'http://localhost:8080/api/post/retrieveAllPosts';
    final response = await http
        .get(Uri.parse(postUrl), headers: {'Authorization': 'Bearer $token'});

    if (response.statusCode == 200) {
      List list = json.decode(response.body);
      return list;
    } else {
      return null;
    }
  }

  Future<bool> deleteUserPost(int id) async {
    String? token = await getToken() ?? '';
    String deleteUrl = 'http://localhost:8080/api/post/delete?id=$id';
    print(deleteUrl);
    final response = await http.delete(Uri.parse(deleteUrl),
        headers: {'Authorization': 'Bearer $token'});
    print(response.statusCode);
    if (response.statusCode == 200) {
      return true;
    } else {
      return false;
    }
  }

  void showSnackBar(BuildContext context) {
    const snackBar = SnackBar(
      content: Text('Error!'),
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }

  bool checkInfo(String topic, List? posts) {
    for (var a in posts ?? []) {
      if (a['category'] == topic) {
        return true;
      }
    }
    return false;
  }

  Color? primColor() => Colors.grey[300];
}
