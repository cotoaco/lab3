package ru.student.main;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import ru.student.geometry.Circle;
import ru.student.geometry.Rectangle;
import ru.student.geometry.Square;
import ru.student.geometry.Triangle;
import ru.student.geometry.Point;
import ru.student.tree.BinarySearchTree;
import ru.student.geometry.PolygonalChain;
import ru.student.geometry.Line;
import ru.student.util.LengthUtils;
import ru.student.geometry.ClosedPolygonalChain;
import ru.student.util.PolygonalChainUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length == 2) {
            try {
                int x = parseInt(args[0]);
                int y = parseInt(args[1]);

                double result = pow(x, y);

                System.out.println(x + " в степени " + y + " = " + result);
                return;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите два целых числа.");
                return;
            }
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       ЛАБОРАТОРНАЯ РАБОТА №3");
        System.out.println("================================");

        System.out.println("Выберите задание:");
        System.out.println("1. Геометрические фигуры");
        System.out.println("2. Бинарное дерево");
        System.out.println("3. Работа с точками и ломаными");
        System.out.println("0. Выход");

        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\n--- ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ ---");

                System.out.print("Введите радиус круга: ");
                double radius = scanner.nextDouble();

                Circle circle = new Circle(new Point(0, 0), radius);
                System.out.println(circle);
                System.out.println("Площадь круга: " + circle.area());

                System.out.print("\nВведите сторону квадрата: ");
                double side = scanner.nextDouble();

                Square square = new Square(new Point(0, 0), side);
                System.out.println("Площадь квадрата: " + square.getArea());
                System.out.println("Периметр квадрата: " + square.getPerimeter());

                System.out.print("\nВведите ширину прямоугольника: ");
                double width = scanner.nextDouble();

                System.out.print("Введите высоту прямоугольника: ");
                double height = scanner.nextDouble();

                Rectangle rectangle = new Rectangle(width, height);
                System.out.println(rectangle);
                System.out.println("Площадь прямоугольника: " + rectangle.area());

                System.out.print("\nВведите три стороны треугольника: ");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();

                Triangle triangle = new Triangle(a, b, c);
                System.out.println(triangle);
                System.out.println("Площадь треугольника: " + triangle.area());

                Square testSquare = new Square(new Point(5, 3), 23);
                PolygonalChain squareChain = testSquare.getPolygonalChain();

                System.out.println("\nЛоманая квадрата: " + squareChain);
                System.out.println("Длина ломаной: " + squareChain.length());

                squareChain.getPoint(3).moveTo(15, 25);

                System.out.println("Длина после перемещения последней точки: "
                        + squareChain.length());

                break;

            case 2:
                System.out.println("\n--- БИНАРНОЕ ДЕРЕВО ---");

                BinarySearchTree tree = new BinarySearchTree();

                System.out.println("Добавляем числа: 3, 5, 4, 7, 1, 2");

                tree.add(3);
                tree.add(5);
                tree.add(4);
                tree.add(7);
                tree.add(1);
                tree.add(2);

                System.out.println("Дерево после добавления: " + tree);

                System.out.print("\nВведите число для поиска: ");
                int searchValue = scanner.nextInt();

                if (tree.contains(searchValue)) {
                    System.out.println("Число найдено!");
                } else {
                    System.out.println("Число не найдено.");
                }

                System.out.print("\nВведите число для удаления: ");
                int removeValue = scanner.nextInt();

                tree.remove(removeValue);

                System.out.println("Дерево после удаления: " + tree);

                break;
            case 3:
                System.out.println("\n--- ТОЧКИ И ЛОМАНЫЕ ---");

                Point p1 = new Point(0, 0);
                Point p2 = new Point(3, 4);
                Point p3 = new Point(6, 4);

                System.out.println("Первая точка: " + p1);
                System.out.println("Вторая точка: " + p2);

                // Длина линии
                Line line = new Line(p1, p2);
                System.out.println("\n" + line);
                System.out.println("Длина линии: " + line.length());

                // Длина ломаной
                PolygonalChain chain1 = new PolygonalChain(p1, p2, p3);
                System.out.println("\nПервая ломаная: " + chain1);
                System.out.println("Длина ломаной: " + chain1.length());
                double totalLength = LengthUtils.sumLength(line, chain1);

                System.out.println("Сумма длин линии и ломаной: " + totalLength);
                ClosedPolygonalChain closedChain = new ClosedPolygonalChain(
                        new Point(0, 0),
                        new Point(3, 0),
                        new Point(3, 4)
                );

                System.out.println("\nЗамкнутая ломаная: " + closedChain);
                System.out.println("Длина замкнутой ломаной: " + closedChain.length());

                // Сравнение ломаных
                PolygonalChain chain2 = new PolygonalChain(
                        new Point(0, 0),
                        new Point(3, 4),
                        new Point(6, 4)
                );

                System.out.println(
                        "\nЛоманые равны: " + chain1.equals(chain2)
                );

                // Объединение двух ломаных
                PolygonalChain mergedChain = chain1.merge(chain2);

                System.out.println("\nОбъединённая ломаная: " + mergedChain);
                System.out.println("Длина объединённой ломаной: " + mergedChain.length());

                // Объединение объектов через интерфейс
                PolygonalChain allChains = PolygonalChainUtils.merge(
                        line,
                        chain1,
                        chain2
                );

                System.out.println("Объединение через интерфейс: " + allChains);

                // Клонирование точки
                Point copy = p1.clone();

                System.out.println("\nКопия первой точки: " + copy);
                System.out.println("Точки равны: " + p1.equals(copy));
                System.out.println("Это один объект: " + (p1 == copy));

                break;

            case 0:
                System.out.println("Программа завершена.");
                break;

            default:
                System.out.println("Неверный пункт меню.");
        }

        scanner.close();
    }
}