import 'package:flutter/material.dart';

class Result extends StatelessWidget {
  const Result({super.key});

  @override
  Widget build(BuildContext context) {
    const IconData science = IconData(0xe55a, fontFamily: 'MaterialIcons');
    return Scaffold(
        appBar: AppBar(
            toolbarHeight: 100,
            backgroundColor: primColor(),
            title:
                Image.asset('assets/old.png', scale: 1.5, fit: BoxFit.cover)),
        backgroundColor: primColor(),
        body: Center(
          child: SingleChildScrollView(
            child: Column(
              children: [
                const SizedBox(
                  height: 40,
                ),
                const HorizontalOrLine(
                    label: 'Statistics', height: 40, icon: science),
                Padding(
                  padding: EdgeInsets.all(20),
                  child: Image.asset('assets/chart0.png'),
                ),
                Padding(
                  padding: EdgeInsets.all(20),
                  child: Image.asset('assets/chart1.png'),
                ),
                Padding(
                  padding: EdgeInsets.all(20),
                  child: Image.asset('assets/chart2.png'),
                ),
                Padding(
                  padding: EdgeInsets.all(20),
                  child: Image.asset('assets/chart3.png'),
                )
              ],
            ),
          ),
        ));
  }
}

class HorizontalOrLine extends StatelessWidget {
  const HorizontalOrLine({
    super.key,
    required this.label,
    required this.height,
    required this.icon,
  });

  final String label;
  final double height;
  final IconData icon;

  @override
  Widget build(BuildContext context) {
    return Row(children: <Widget>[
      Expanded(
        child: Container(
            margin: const EdgeInsets.only(left: 10.0, right: 15.0),
            child: Divider(
              thickness: 5.0,
              color: Colors.black,
              height: height,
            )),
      ),
      Text(
        '$label  ',
        style: const TextStyle(fontSize: 25),
      ),
      Icon(
        icon,
        size: 25,
      ),
      Expanded(
        child: Container(
            margin: const EdgeInsets.only(left: 15.0, right: 10.0),
            child: Divider(
              thickness: 5.0,
              color: Colors.black,
              height: height,
            )),
      ),
    ]);
  }
}

Color? primColor() => Colors.grey[300];
