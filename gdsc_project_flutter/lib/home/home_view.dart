import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:gdsc_project/home/create_post.dart';
import './home_view_model.dart';

class HomeView extends HomeViewModel {
  List? _feed;
  Color _buttonColor = Colors.red;
  int _page = 0;

  final List<String> icons = [
    'assets/washing_machine.png',
    'assets/dishwasher.png',
    'assets/energy.png',
    'assets/kitchen.png',
    'assets/hygiene.png',
    'assets/garbage.png',
    'assets/vacuum_cleaner.png'
  ];

  int checkIndex(String? category) {
    if (category == 'Washing Machine') {
      return 0;
    }
    if (category == 'Dishwasher') {
      return 1;
    }
    if (category == 'Energy Consumption') {
      return 2;
    }
    if (category == 'Kitchen') {
      return 3;
    }
    if (category == 'Personal Hygiene') {
      return 4;
    }
    if (category == 'Rubbish') {
      return 5;
    }
    if (category == 'Vacuum Cleaner') {
      return 6;
    } else {
      return 0;
    }
  }

  Future<void> assignPosts() async {
    var feed = await getFeed();
    setState(() {
      _feed = feed;
      _page += 1;
    });
  }

  @override
  void initState() {
    super.initState();
    assignPosts();
  }

  @override
  Widget build(BuildContext context) {
    // Replace this with your build function
    return Scaffold(
        backgroundColor: primColor(),
        appBar: AppBar(
            toolbarHeight: 100,
            backgroundColor: primColor(),
            title: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Image.asset('assets/old.png', scale: 1.5, fit: BoxFit.cover),
                FloatingActionButton(
                  onPressed: () async {
                    final value = await Navigator.push(context,
                        MaterialPageRoute(builder: (context) => Posting()));
                    setState(() {
                      assignPosts();
                    });
                  },
                  backgroundColor: Colors.black87,
                  focusColor: Colors.black,
                  heroTag: 'Add Post',
                  child: const Icon(CupertinoIcons.add),
                )
              ],
            )),
        body: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Center(
                child: ListView.separated(
                  scrollDirection: Axis.vertical,
                  shrinkWrap: true,
                  padding: const EdgeInsets.all(40),
                  itemCount: _feed?.length ?? 0,
                  itemBuilder: (BuildContext context, index) {
                    return InkWell(
                      onTap: () {},
                      child: Ink(
                          padding: EdgeInsets.all(18),
                          decoration: BoxDecoration(
                              border: Border.all(width: 2),
                              color: Color.fromARGB(255, 255, 255, 249),
                              borderRadius: BorderRadius.circular(20)),
                          child: Flexible(
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Image.asset(
                                  icons[checkIndex(
                                      _feed?[index]['category'] ?? '')],
                                  scale: 4,
                                ),
                                const SizedBox(
                                  width: 10,
                                ),
                                Container(
                                  child: Expanded(
                                    child: Column(
                                      mainAxisSize: MainAxisSize.min,
                                      children: [
                                        Flexible(
                                          child: Row(
                                            mainAxisAlignment:
                                                MainAxisAlignment.spaceBetween,
                                            children: [
                                              Text(
                                                  _feed?[index]['username'] ??
                                                      '',
                                                  style: const TextStyle(
                                                      fontSize: 25,
                                                      fontWeight:
                                                          FontWeight.bold)),
                                              Text(
                                                  _feed?[index]['category'] ??
                                                      '',
                                                  style: const TextStyle(
                                                      fontSize: 20,
                                                      fontWeight:
                                                          FontWeight.bold)),
                                            ],
                                          ),
                                        ),
                                        const SizedBox(
                                          height: 25,
                                        ),
                                        Explanation(
                                          index: index,
                                          posts: _feed,
                                        ),
                                      ],
                                    ),
                                  ),
                                ),
                                const SizedBox(
                                  width: 10,
                                )
                              ],
                            ),
                          )),
                    );
                  },
                  separatorBuilder: (BuildContext context, int index) =>
                      const Divider(
                    height: 50,
                  ),
                ),
              ),
              const SizedBox(
                height: 25,
              )
            ],
          ),
        ));
  }
}

class Explanation extends StatelessWidget {
  const Explanation({super.key, required this.posts, required this.index});

  final List? posts;
  final int index;

  @override
  Widget build(BuildContext context) {
    return SelectableText(
      posts?[index]['explanation'] ?? '',
      style: const TextStyle(fontSize: 17.5),
    );
  }
}
