import 'package:flutter/material.dart';
import 'package:gdsc_project/cache/auth_manager.dart';
import 'package:gdsc_project/home/const_nav_bar.dart';
import 'package:provider/provider.dart';

import 'login/login.dart';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  Future<void> controltoApp() async {
    /*await readAuthManager.fetchUserLogin();*/
    await Future.delayed(const Duration(seconds: 1));
    Navigator.pushReplacement(
        context, MaterialPageRoute(builder: (context) => Login()));
  }

  AuthanticationManager get readAuthManager =>
      context.read<AuthanticationManager>();

  @override
  void initState() {
    super.initState();
    controltoApp();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(child: CircularProgressIndicator()),
    );
  }
}
