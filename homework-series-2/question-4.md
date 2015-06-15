Question 4
----------

1.

```
| main | a = [1..2] |
--ARP----------------
|      | static     |

```

2.

```
| main    | a = [3, 10]         |
|         | return address = 37 |
--ARP--------------------------------<
|         | static              |     |
| perform | x                   |     |
|         | return address = 29 |     |
--ARP-----------------------------<   |
|         | static              |--|--
|         | a = [3, 10]         |  |
| setX    | static              |--
|         | b = false           |
```

3.

```
| main    | a = [3, 10]         |
|         | return address = 37 |
--ARP--------------------------------<
|         | static              |     |
| perform | a = [3, 10]         |     |
|         | x                   |     |
|         | return address = 29 |     |
--ARP-----------------------------<   |
|         | static              |--|--|
| setX    | b = false           |  |  |
|         | return address = 25 |  |  |
--ARP----------------------------  |  |
|         | static              |--   |
| max     | x = 3               |     |
|         | y = 10              |     |
|         | r                   |     |
|         | static              |-----
```

4.

```
| main    | a = [10, 10]        |
|         | return address = 37 |
--ARP------------------------------<
|         | static              |  |
| perform | x = 10              |  |
--ARP----------------------------  |
|         | static              |--
