class ResultDTO<T> {
  int count;
  String next;
  String previous;
  List<T> results;

  ResultDTO({this.count, this.next, this.previous, this.results});

  factory ResultDTO.fromJson(Map<String, dynamic> json) {
    var resultList = json['results'] as List;

    return ResultDTO(
      count: json['count'],
      next: json['next'],
      previous: json['previous'],
      results: resultList.map().toList();
    );
  }
}