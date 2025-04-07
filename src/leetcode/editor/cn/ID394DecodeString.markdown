初始状态:
- str = ""
- numStack = []
- strStack = []

步骤1: 读取 '3'
- count = 3

步骤2: 读取 '['
- numStack = [3]
- strStack = [""]
- str = ""

步骤3: 读取 'a'
- str = "a"

步骤4: 读取 '2'
- count = 2

步骤5: 读取 '['
- numStack = [3, 2]
- strStack = ["", "a"]
- str = ""

步骤6: 读取 'c'
- str = "c"

步骤7: 读取 ']'
- numStack = [3]
- strStack = [""]
- str = "cc"
- temp = "acc"

步骤8: 读取 ']'
- numStack = []
- strStack = []
- str = "accaccacc"
