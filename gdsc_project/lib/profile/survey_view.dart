import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter/src/widgets/placeholder.dart';
import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

class Survey extends StatefulWidget {
  final String url;
  const Survey({Key? key, required this.url}) : super(key: key);

  @override
  State<Survey> createState() => _SurveyState();
}

class _SurveyState extends State<Survey> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          toolbarHeight: 100,
          backgroundColor: primColor(),
          title: Image.asset('assets/old.png', scale: 1.5, fit: BoxFit.cover)),
      body: Center(
          child: AspectRatio(
              aspectRatio: 16 / 9,
              child: WebView(
                initialUrl: widget.url,
                allowsInlineMediaPlayback: true,
                debuggingEnabled: true,
                initialMediaPlaybackPolicy:
                    AutoMediaPlaybackPolicy.always_allow,
                javascriptMode: JavascriptMode.unrestricted,
                onWebResourceError: (webresourceerror) {
                  print(webresourceerror.domain.toString());
                },
                onPageStarted: (String page) {},
                onPageFinished: (String page) {},
                onWebViewCreated: (WebViewController webViewController) {
                  try {} catch (error, stackTrace) {}
                },
              ))),
    );
  }
}

Color? primColor() => Colors.grey[300];
