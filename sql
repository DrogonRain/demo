2、查询各个学科的平均成绩，最高成绩。
SELECT 
e.name '学科名称' ,
AVG(sc.score) '平均成绩',
MAX(sc.score) '最高成绩' 
FROM 
course e 
LEFT JOIN scores sc 
ON e.t_id = sc.c_id 
GROUP BY e.name;
3、查询每个同学的最高成绩及科目名称。
SELECT 
t.name '学生名称',
t.score '最高成绩', 
e.name '科目名称' 
FROM (
SELECT 
s.id ,
s.name ,
MAX(sc.score) score
FROM 
student s 
LEFT JOIN scores sc 
ON s.id = sc.s_id 
GROUP BY s.id) t LEFT JOIN scores sc 
ON t.id = sc.s_id and t.score = sc.score 
LEFT JOIN course e 
ON e.t_id = sc.c_id; 
