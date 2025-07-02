class Complaint {
  final int id;
  final String title;
  final String description;
  final String status;
  final DateTime createdAt;

  Complaint({
    required this.id,
    required this.title,
    required this.description,
    required this.status,
    required this.createdAt,
  });

  factory Complaint.fromJson(Map<String, dynamic> json) {
    return Complaint(
      id: json['id'],
      title: json['title'],
      description: json['description'],
      status: json['status'],
      createdAt: DateTime.parse(json['createdAt']),
    );
  }
}
