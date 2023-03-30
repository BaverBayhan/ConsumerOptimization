import 'dart:convert';
import '../models/feed_model.dart';
import 'package:flutter/material.dart';
import 'package:gdsc_project/cache/cache_manager.dart';
import './home.dart';
import 'package:http/http.dart' as http;

abstract class HomeViewModel extends State<Home> with CacheManager {
  // Add your state and logic here
  Future<List?> getFeed() async {
    String? token = await getToken() ?? '';
    const String feedUrl = 'http://localhost:8080/api/post/feed?page=0';
    final response = await http
        .get(Uri.parse(feedUrl), headers: {'Authorization': 'Bearer $token'});

    if (response.statusCode == 200) {
      List? list = json.decode(response.body);
      return list;
    } else {
      return null;
    }
  }

  Color? primColor() => Colors.grey[300];
}
