SELECT student.SNO , student.name , course.CourseName , choose.Score FROM Student , Course , Choose WHERE Student.`SNO` = choose.`SNO` AND choose.`CourseID` = course.`CourseID`;