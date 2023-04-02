import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:gdsc_project/cache/cache_manager.dart';
import 'package:gdsc_project/models/posting_model.dart';
import 'package:http/http.dart' as http;
import 'package:intl/intl.dart';

class Posting extends StatefulWidget {
  const Posting({super.key});

  @override
  State<Posting> createState() => _PostingState();
}

class _PostingState extends State<Posting> with CacheManager {
  String? token = '';
  var time = DateTime.now();
  String? selected_item = 'Washing Machine';
  final TextEditingController _explanationController = TextEditingController();
  final TextEditingController _timeController = TextEditingController();
  final List<String> entries = <String>[
    'Washing Machine',
    'Dishwasher',
    'Energy Consumption',
    'Kitchen',
    'Personal Hygiene',
    'Rubbish',
    'Vacuum Cleaner'
  ];

  final GlobalKey<ScaffoldState> _scaffoldKey = GlobalKey<ScaffoldState>();

  void showSnackBar(BuildContext context) {
    const snackBar = SnackBar(
      content: Text('Please fill the required blanks correctly!'),
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }

  void getUserToken() async {
    token = await getToken() ?? '';
    setState(() {});
  }

  Future<bool> PosttoFeed(String? token, PostingModel model) async {
    const String saveUrl = 'http://localhost:8080/api/post/save';
    final response = await http.post(Uri.parse(saveUrl),
        headers: {
          "Content-Type": "application/json",
          "Authorization": "Bearer $token"
        },
        body: json.encode({
          'category': model.category,
          'explanation': model.explanation,
          'timeCreated': model.timeCreated
        }));
    if (response.statusCode == 201) {
      return true;
    } else {
      return false;
    }
  }

  @override
  void initState() {
    super.initState();
    getUserToken();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: _scaffoldKey,
      appBar: AppBar(
          toolbarHeight: 100,
          backgroundColor: primColor(),
          title: Image.asset('assets/old.png', scale: 1.5, fit: BoxFit.cover)),
      body: Center(
        child: Column(mainAxisAlignment: MainAxisAlignment.center, children: [
          const Padding(
              padding: EdgeInsets.all(20.0),
              child: Text(
                'Share Your Thoughts With Us!',
                style: TextStyle(fontSize: 30),
              )),
          Padding(
            padding: const EdgeInsets.all(20.0),
            child: SizedBox(
              width: 300,
              child: DropdownButtonFormField<String>(
                style: TextStyle(fontSize: 50, color: Colors.black),
                itemHeight: 70.0,
                value: selected_item,
                isExpanded: true,
                decoration: const InputDecoration(
                    prefixIcon: Icon(
                      Icons.topic,
                      color: Colors.black,
                    ),
                    label: Text(
                      'Topic',
                      style: TextStyle(color: Colors.black, fontSize: 30),
                    )),
                items: entries
                    .map((item) => DropdownMenuItem<String>(
                          value: item,
                          child: Text(
                            item,
                            style: const TextStyle(fontSize: 20),
                          ),
                        ))
                    .toList(),
                onChanged: (item) => setState(() => selected_item = item),
              ),
            ),
          ),
          Padding(
            padding: EdgeInsets.all(20),
            child: TextFormField(
              keyboardType: TextInputType.multiline,
              minLines: 1,
              maxLines: 10,
              decoration: const InputDecoration(
                  contentPadding:
                      EdgeInsets.symmetric(vertical: 20.0, horizontal: 20),
                  focusedBorder: OutlineInputBorder(
                      borderSide: BorderSide(
                    color: Colors.black,
                  )),
                  border: OutlineInputBorder(),
                  labelText: 'Enter What You Want!',
                  labelStyle: TextStyle(color: Colors.black)),
              controller: _explanationController,
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Please enter your thoughts.';
                }
                return null;
              },
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(20),
            child: GestureDetector(
              onTap: () async {
                print(_explanationController.toString());
                var enter = await PosttoFeed(
                    token,
                    PostingModel(
                        category: selected_item,
                        explanation: _explanationController.text,
                        timeCreated: '2023-03-26T16:33:53.829Z'));
                if (enter == true) {
                  Navigator.pop(context);
                } else {
                  showSnackBar(context);
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
                        "Post! ",
                        style: TextStyle(
                            color: Colors.white,
                            fontSize: 25,
                            fontWeight: FontWeight.bold),
                      ),
                      Icon(
                        Icons.upload,
                        color: Colors.white,
                        size: 20,
                      )
                    ]),
              ),
            ),
          )
        ]),
      ),
    );
  }
}

Color? primColor() => Colors.grey[300];
