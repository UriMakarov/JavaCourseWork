INSERT INTO users (first_name, last_name, department)
VALUES ('John', 'Doe', 'IT'),
       ('Jane', 'Smith', 'HR'),
       ('Bob', 'Jones', 'Finance');

INSERT INTO tasks (description, deadline)
VALUES ('Task 1', '2025-01-01'),
       ('Task 2', '2025-02-01'),
       ('Task 3', '2025-03-01');

INSERT INTO user_tasks (user_id, task_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 3),
       (3, 2);