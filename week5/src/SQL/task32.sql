SELECT choose.`SNO` , Choose.`Score`
FROM Choose
WHERE choose.`CourseID` = 'C1'
AND choose.`Score` < (SELECT choose.`Score`
                      FROM choose
                      WHERE choose.`CourseID`='C1'
                      AND choose.`SNO`=(SELECT student.`SNO`
                                        FROM student
                                        WHERE student.`name`='张三'))
