import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:gdsc_project/cache/cache_manager.dart';
import 'package:gdsc_project/home/const_nav_bar.dart';
import 'package:gdsc_project/models/user_info_model.dart';
import 'package:gdsc_project/register/register_view_model.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http;

import '../home/home.dart';

class RegisteredUserInfo extends StatefulWidget {
  const RegisteredUserInfo({super.key});

  @override
  State<RegisteredUserInfo> createState() => _RegisteredUserInfoState();
}

class _RegisteredUserInfoState extends State<RegisteredUserInfo>
    with CacheManager {
  final TextEditingController _provinceController = TextEditingController();
  final TextEditingController _peopleController = TextEditingController();
  final TextEditingController _professionController = TextEditingController();
  final TextEditingController _salaryController = TextEditingController();
  List<String> marital_status = ['Married', 'Single', 'Prefer not to Say'];
  String? selected_item = 'Prefer not to Say';
  String? token = '';

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

  Future<bool> saveData(String? token, UserInfoModel model) async {
    const String infoUrl = 'http://localhost:8080/api/userinfo/save';
    final response = await http.post(Uri.parse(infoUrl),
        headers: {
          "Content-Type": "application/json",
          "Authorization": "Bearer $token"
        },
        body: jsonEncode({
          'city': model.city,
          'memberNumberInHome': model.memberNumberInHome,
          'job': model.job,
          'civilStatus': model.civilStatus,
          'annualSalary': model.annualSalary
        }));
    if (response.statusCode == 201) {
      return true;
    } else {
      return false;
    }
  }

  void getUserToken() async {
    token = await getToken() ?? '';
    setState(() {});
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    getUserToken();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.grey[300],
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: Image.asset('assets/old.png',
                    scale: 1.5, fit: BoxFit.cover),
              ),
              const Padding(
                padding: EdgeInsets.all(30.0),
                child: Text(
                  'Personal Data',
                  style: TextStyle(fontSize: 40, fontWeight: FontWeight.bold),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(20.0),
                child: Text(
                  'Please Fill the Required Blanks',
                  style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: TextFormField(
                  controller: _provinceController,
                  decoration: const InputDecoration(
                      prefixIcon: Icon(
                        Icons.location_city,
                        color: Colors.black,
                      ),
                      focusedBorder: OutlineInputBorder(
                          borderSide: BorderSide(
                        color: Colors.black,
                      )),
                      border: OutlineInputBorder(),
                      labelText: 'City',
                      labelStyle: TextStyle(color: Colors.black)),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter a city';
                    }
                    return null;
                  },
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: TextFormField(
                  controller: _peopleController,
                  keyboardType: TextInputType.number,
                  decoration: const InputDecoration(
                      prefixIcon: Icon(
                        Icons.house_rounded,
                        color: Colors.black,
                      ),
                      focusedBorder: OutlineInputBorder(
                          borderSide: BorderSide(
                        color: Colors.black,
                      )),
                      border: OutlineInputBorder(),
                      labelText: 'Number of Members in the House',
                      labelStyle: TextStyle(color: Colors.black)),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter a value';
                    }
                    return null;
                  },
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: TextFormField(
                  controller: _salaryController,
                  keyboardType: TextInputType.number,
                  decoration: const InputDecoration(
                      prefixIcon: Icon(
                        Icons.money_rounded,
                        color: Colors.black,
                      ),
                      focusedBorder: OutlineInputBorder(
                          borderSide: BorderSide(
                        color: Colors.black,
                      )),
                      border: OutlineInputBorder(),
                      labelText: 'Salary (Approx.)',
                      labelStyle: TextStyle(color: Colors.black)),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter a value';
                    }
                    return null;
                  },
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: TextFormField(
                  controller: _professionController,
                  decoration: const InputDecoration(
                      prefixIcon: Icon(
                        Icons.work,
                        color: Colors.black,
                      ),
                      focusedBorder: OutlineInputBorder(
                        borderSide: BorderSide(
                          color: Colors.black,
                        ),
                      ),
                      border: OutlineInputBorder(),
                      labelText: 'Profession',
                      labelStyle: TextStyle(color: Colors.black)),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter a profession';
                    }
                    return null;
                  },
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: SizedBox(
                  width: 300,
                  child: DropdownButtonFormField<String>(
                    value: selected_item,
                    isExpanded: true,
                    decoration: const InputDecoration(
                        prefixIcon: Icon(
                          Icons.accessibility_new_rounded,
                          color: Colors.black,
                        ),
                        label: Text(
                          'Martial Status',
                          style: TextStyle(fontSize: 25, color: Colors.black),
                        )),
                    items: marital_status
                        .map((item) => DropdownMenuItem<String>(
                              value: item,
                              child: Text(
                                item,
                                style: const TextStyle(fontSize: 15),
                              ),
                            ))
                        .toList(),
                    onChanged: (item) => setState(() => selected_item = item),
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: GestureDetector(
                    onTap: () async {
                      var enter = await saveData(
                          token,
                          UserInfoModel(
                              city: _provinceController.text.trim(),
                              memberNumberInHome: _peopleController.text.trim(),
                              job: _professionController.text.trim(),
                              annualSalary:
                                  int.parse(_salaryController.text.trim()),
                              civilStatus: selected_item));
                      if (enter == true) {
                        navigatetoHome();
                      } else {
                        return showSnackBar(context);
                      }
                    },
                    child: Container(
                      width: 200.0,
                      height: 50,
                      color: Colors.black,
                      child: Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: const [
                            Text(
                              "Continue ",
                              style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 20,
                                  fontWeight: FontWeight.bold),
                            ),
                            Icon(
                              color: Colors.white,
                              Icons.arrow_right_alt,
                              size: 20,
                            )
                          ]),
                    )),
              ),
            ],
          ),
        ));
  }
}
