import 'package:flutter/material.dart';

Widget customText(
  String value,
  String font,
  double size,
  FontWeight fontWeight,
  Color? color,
) {
  return Text(
    value,
    style: TextStyle(
      fontFamily: font,
      fontSize: size,
      fontWeight: fontWeight,
      color: color,
    ),
  );
}

Widget customButton(Widget? child, context, double? height, double? width) {
  return Container(
    height: height,
    width: width,
    decoration: BoxDecoration(
      borderRadius: BorderRadius.circular(8),
      border: Border.all(),
      color: Color.fromRGBO(0, 87, 216, 1),
    ),
    child: Center(child: child),
  );
}

Widget customButtonWhite(Widget? child, context, Color color) {
  return Container(
    height: 40,
    width: 150,
    decoration: BoxDecoration(
      borderRadius: BorderRadius.circular(6),
      border: Border.all(color: Color.fromRGBO(0, 87, 216, 1)),
      color: color,
    ),
    child: Center(child: child),
  );
}

Widget customButton3(Widget? child, context, Color color) {
  return Container(
    height: 40,
    decoration: BoxDecoration(
      borderRadius: BorderRadius.circular(6),
      border: Border.all(color: Color.fromRGBO(0, 87, 216, 1)),
      color: color,
    ),
    child: Center(child: child),
  );
}


 Widget customStatusIcon(String status) {
    switch (status) {
      case "done":
        return const CircleAvatar(
          radius: 12,
          backgroundColor: Colors.green,
          child: Icon(Icons.check, size: 14, color: Colors.white),
        );
      case "review":
        return const CircleAvatar(
          radius: 12,
          backgroundColor: Colors.orange,
          child: Icon(Icons.circle, size: 10, color: Colors.white),
        );
      default:
        return CircleAvatar(
          radius: 12,
          backgroundColor: Colors.grey.shade300,
          child: const Icon(
            Icons.circle_outlined,
            size: 14,
            color: Colors.white,
          ),
        );
    }
  }