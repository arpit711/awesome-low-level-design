FoodKart
Description:
Implement a food order management system.
The system has the following features - 
1. This system has a tie-up with restaurants, where each restaurant has a menu. The menu consists of the items and their corresponding prices.
2. Each restaurant has a maximum processing capacity in terms of number of items at any given time. It won’t accept any further orders until the orders which are being processed are dispatched.
3. Once an order is dispatched it notifies the system about it. Depending on the processing capacity it can take more orders.
4. Only one restaurant can be selected for an order based on the restaurant selection strategy.
5. An order is accepted only if all the items can be fulfilled by the selected restaurant.

What should the system do?
1. Onboard a new restaurant with its items menu and processing capacity.
2. Any restaurant should be able to change its menu or update prices.
3. Any restaurant should be able to mark an order as dispatched.
4. The customer should be able to place an order by giving items.
5. Implement one restaurant selection strategy. eg: restaurants can be selected based on the lowest price of the item. This should be extensible for adding new selection algorithms.
6. The system should be able to keep track of all items served by each restaurant.
7. Given an unordered list of commands, execute the commands ordered by timestamp and occurrence.
8.  Bonus - List all the dispatched orders.


Example commands:

5,  place-order,  order2,  item1,  item2,  item3
2,  update-price,  restaurant3,   item1,  50
8,  dispatch-order,  order2
5,  place-order,  order3,  item2,  item3
3,  place-order,  order1,  item1




Output

>> 2,  update-price,  restaurant3,  item1,  50
Print Menu of the Restaurant

>> 3,  place-order,  order1,  item1
Print Order Total and Restaurant name if it's placed successfully

>> 5,  place-order,  order2,  item1,  item2,  item3
Print Order Total and Restaurant name if it’s placed successfully 

>> 5,  place-order,  order3,  item2,  item3
                                                                 Print Order Total and Restaurant name if it’s placed successfully 

>> 8,  dispatch-order,  order2
                                                                                                                                  Print the order


Expectations:
* Code should be demo-able (very important). Code should be functionally correct and complete.
    * At the end of this interview round, an interviewer will provide multiple inputs to your program for which it is expected to work 
* Code should handle edge cases properly and fail gracefully. Add suitable exception handling, wherever applicable.
* Code should have a good object-oriented design.
* Code should be readable, modular, testable and extensible. Use intuitive names for your variables, methods and classes.
    * It should be easy to add/remove functionality without rewriting a lot of code.
    * Do not write monolithic code.


Guidelines:
* Duration: 120 mins (including 30 mins of briefing time).
* Input can be read from a file or STDIN or coded in a driver method.
* Output can be written to a file or STDOUT.
* You are not allowed to use any external databases like MySQL. Use only in-memory data structures.
* No need to create any UX or any HTTP API. It should be a standalone application.
* Please focus on the Bonus Features only after ensuring the required features are complete and demo-able.
* You are free to use the language of your choice.


Exception handling, readable, modular, extensible, testable, code naming variables and easy to understand.
SOLID principles KISS DRY all principles to be followed.

Input to be coded in driver class

No extrernal DB to be used here.