import re
import javalang
from javalang import tree
import csv
from os import listdir
from os.path import isfile, join
mypath = 'crawled_codes/'

def state_counter(typelist):
    num_state = 0
    num_state += typelist.count(javalang.tree.IfStatement)
    num_state += typelist.count(javalang.tree.WhileStatement)
    num_state += typelist.count(javalang.tree.DoStatement)
    num_state += typelist.count(javalang.tree.ForStatement)
    num_state += typelist.count(javalang.tree.AssertStatement)
    num_state += typelist.count(javalang.tree.BreakStatement)
    num_state += typelist.count(javalang.tree.ContinueStatement)
    num_state += typelist.count(javalang.tree.ReturnStatement)
    num_state += typelist.count(javalang.tree.ThrowStatement)
    num_state += typelist.count(javalang.tree.SynchronizedStatement)
    num_state += typelist.count(javalang.tree.TryStatement)
    num_state += typelist.count(javalang.tree.SwitchStatement)
    num_state += typelist.count(javalang.tree.BlockStatement)
    return num_state


class AppExtractValue:
    def __init__(self):
        pass

    def complexity_class(self,x):
        return {
            '1':'constant',
            'log n':'logarithmic',
            'logn':'logarithmic',
            'log(n':'logarithmic',
            'log|n|':'logarithmic',
            'logv':'logarithmic',
            'log v':'logarithmic',
            'log b':'logarithmic',
            'log n (log log n':'logarithmic',
            'n^1/2':'sublinear',
            'n/m':'sublinear',
            '(min(r, n-r^2  * log(n':'linearithmic',
            'n log n':'linearithmic',
            'e log v':'linearithmic',
            'nlogn':'linearithmic',
            'n * log n':'linearithmic',
            'n log k':'linearithmic',
            'm log m + n log m':'linearithmic',
            'n*log(log(n':'linearithmic',
            'n*log(n':'linearithmic',
            '|n|':'linear',
            '|num1|':'linear',
            'n':'linear',
            'b':'linear',
            'm':'linear',
            'k':'linear',
            'r':'linear',
            'x':'linear',
            'y':'linear',
            'v':'linear',
            'v+e':'linear',
            'n+m':'linear',
            'm+n':'linear',
            'n+k':'linear',
            'n1 + n2 + n3':'linear',
            'n + m + z':'linear',
            'min(x, y, z':'linear',
            'n + range':'linear',
            'sum':'linear',
            'k + (n-k':'linear',
            'k + O((m * log(k':'linear',
            'n^2':'quadratic',
            'n_square':'quadratic',
            '|n|^2':'quadratic',
            'n2':'quadratic',
            'n^3':'polynomial',
            'v^3':'polynomial',
            'n^4':'polynomial',
            've':'quadratic',
            'nm':'quadratic',
            'nl':'quadratic',
            'sum*n':'quadratic',
            'max_flow * e':'quadratic',
            'n |n|':'quadratic',
            'num * |num|':'quadratic',
            'mn':'polynomial',
            'mv':'polynomial',
            'nw':'quadratic',
            'k*n':'quadratic',
            'nk':'quadratic',
            'n*k':'quadratic',
            'm*no_of_chars':'quadratic',
            'a * b':'quadratic',
            'e*(v+e':'polynomial',
            'v*(v+e':'polynomial',
            'v^2 + e':'quadratic',
            'm*no_of_chars':'quadratic',
            '2^n':'exponential',
            '3^m':'exponential',
            'v^k':'exponential',
            'n*(2^n':'exponential',
            'v^3k':'exponential',
            'n*2n':'exponential',
            'nk':'exponential',
            'n^2 * m':'exponential',
            'm^2k + k^3 log n':'exponential',
            '8^(n^2':'exponential',
            '9^(n*n':'exponential',
            'n x n!':'exponential'       

        }.get(x,'other')

    def extract_efficiency(self, c_class):
        return{
            'constant':'efficient',
            'logarithmic':'efficient',
            'sublinear':'efficient',
            'linear':'efficient',
            'linearithmic':'efficient',
            'quadratic':'inefficient',
            'polynomial':'inefficient',
            'exponential':'inefficient',
            'double-exponential':'inefficient'
        }.get(c_class,'other')
        
    def extract_values(self, filename, file_complexity=""):
        path_to_file = mypath + filename
        file = open(path_to_file)
        source = file.read()
        file.close()
        if file_complexity == "":
            s_list= source.split("\n")
            complexity = re.sub('//O\(','',s_list[1])
            complexity = re.sub('\)','',complexity)
        else:
            complexity = file_complexity

        c_class=self.complexity_class(complexity)
        efficiency= self.extract_efficiency(c_class)
        try:
            tree = javalang.parse.parse(source)
        except:
            return []

        typelist = []

        num_recursive = 0
        num_nasted_loop = 0
        num_hash_map = 0
        num_hash_set = 0
        num_Priority = 0
        num_sort = 0
        num_binSearch = 0
        num_minMax = 0

        for path, node in tree:
            typelist.append(type(node))
            if type(node) == javalang.tree.MethodDeclaration:
                temp_name = node.name
                if node.name+',' in str(node).replace('name=' + temp_name, ''):
                    num_recursive = str(node).replace('name=' + temp_name, '').count(node.name+',')
            if type(node) == javalang.tree.ForStatement:
                if str(node).count('ForStatement') + str(node).count('WhileStatement') != 1 and (str(node).count('ForStatement') + str(node).count('WhileStatement') ) > num_nasted_loop:
                    num_nasted_loop = str(node).count('ForStatement') + str(node).count('WhileStatement')
            

            if type(node) == javalang.tree.LocalVariableDeclaration:
                try:
                    if node.declarators[0].initializer.type.name == 'HashMap':
                        num_hash_map += 1
                    elif node.declarators[0].initializer.type.name == 'HashSet':
                        num_hash_set += 1
                    elif node.declarators[0].initializer.type.name == 'PriorityQueue':
                        num_Priority += 1

                except:
                    pass
            if type(node) == javalang.tree.MethodInvocation:

                if node.member == 'sort' and node.member != temp_name:
                    num_sort += 1
                if node.member == 'binarySearch' and node.member != temp_name:
                    num_binSearch += 1
                
                if (node.member == 'min' or node.member == 'max')  and node.member != temp_name:
                    num_minMax += 1


        num_if = typelist.count(javalang.tree.IfStatement)
        num_else = str(tree).count("else_statement=B")
        num_loof = typelist.count(javalang.tree.ForStatement) + typelist.count(javalang.tree.WhileStatement)
        num_vari = typelist.count(javalang.tree.VariableDeclaration) + typelist.count(javalang.tree.LocalVariableDeclaration)
        num_break = typelist.count(javalang.tree.BreakStatement)
        num_method = typelist.count(javalang.tree.MethodDeclaration)
        num_switch = typelist.count(javalang.tree.SwitchStatement)
        num_state = state_counter(typelist)

        return [num_if, num_else, num_switch, num_loof, num_break, num_Priority,num_binSearch,num_minMax, num_sort, num_hash_map, num_hash_set, num_recursive, num_nasted_loop, num_vari, num_method, num_state,complexity,c_class,efficiency,filename]
    


magic = AppExtractValue()

details = ["num_if", "num_else", "num_switch", "num_loof", "num_break", "num_Priority","num_binSearch","num_minMax", "num_sort", "num_hash_map", "num_hash_set", "num_recursive", "num_nasted_loop", "num_vari", "num_method", "num_state","complexity","complexity_class","efficiency","filename"]

onlyfiles = [f for f in listdir(mypath) if isfile(join(mypath, f))]

rows = []
for file in onlyfiles:
    rows.append(magic.extract_values(file,""))

#rows = magic.extract_values("linearSearch.java")

with open('database.csv', 'w') as f: 
    write = csv.writer(f) 
    write.writerow(details) 
    write.writerows(rows) 

rows = []
mypath = 'base_dados/code_java/'
with open('base_dados/base_path_file_complexity.csv','r') as file:
    csv_reader = csv.reader(file)
    next(csv_reader)
    for row in csv_reader:
        rows.append(magic.extract_values(row[15],row[14])) 

with open('database_paper.csv', 'w') as f: 
    write = csv.writer(f) 
    write.writerow(details) 
    write.writerows(rows) 