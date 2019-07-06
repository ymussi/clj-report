# # # def dpMakeChange(coinValueList,change,minCoins):
    
# # #    for cents in range(change+1):

# # #       coinCount = cents

# # #       for j in [c for c in coinValueList if c <= cents]:

# # #             if minCoins[cents-j] + 1 < coinCount:

# # #                coinCount = minCoins[cents-j]+1

# # #       minCoins[cents] = coinCount

# # #    return minCoins[change]


# # # def main():

# # #     amnt = 72

# # #     clist = [1,5,10,25,50]

# # #     coinCount = [0]*(amnt+1)

# # #     print(dpMakeChange(clist,amnt,coinCount),"moedas")



# # # main()
# # import numpy as np

# # x = [10, 20, 30]

# # x = np.append(x, [[40, 50, 60], [70, 80, 90]])

# # print(x)

# grades = dict(zip(['Michelangelo', 'Rafael', 'Donatello', 'Leonardo'], [4, 2, 10, 7]))

# approved =  dict( (key, value) for (key, value) in grades.items() if value > 5 )


# print(approved)

def f(input, array=[]):
    
    for index in range(input):

        array.append(index * index)

    print(array)

f(2)

f(3,[3,2,1])

f(3)
