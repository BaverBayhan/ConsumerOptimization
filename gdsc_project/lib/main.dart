import 'package:flutter/material.dart';
import 'package:gdsc_project/cache/auth_manager.dart';
import 'package:gdsc_project/home/const_nav_bar.dart';
import 'package:gdsc_project/home/create_post.dart';
import 'package:gdsc_project/profile/survey_view.dart';
import 'package:gdsc_project/register/registered_user_info.dart';
import 'package:gdsc_project/splash_screen.dart';
import 'package:provider/provider.dart';
import 'home/home.dart';
import 'login/login.dart';

void main() {
  runApp(MultiProvider(
    providers: [
      Provider<AuthanticationManager>(
        create: ((context) => AuthanticationManager(context: context)),
        lazy: true,
      )
    ],
    child: MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'MyApp',
        debugShowCheckedModeBanner: false,
        home: SplashScreen());
  }
}
