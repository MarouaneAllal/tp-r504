import pytest
import fonctions as f

def test_1 ( ) :
    assert f.puissance ( 2 , 3 ) == 8
    assert f.puissance ( 2 , 2 ) == 4
    
def test_2 ( ) :
    assert f.puissance ( 1 , 1 ) == 1
    assert f.puissance ( 2, 1 ) == 2
    
#def test_3 ( ) :
#    if f.puissance ( 0, -2 ):


def test_zero_division():
    with pytest.raises(ArithmeticError):
         assert f.puissance (0 , -2)

         assert f.puissance ( 0 , 0 ) == 1
         assert f.puissance ( 1, -2 ) == 1
         assert f.puissance ( 1 , 2 ) == 1
         assert f.puissance ( 2 , 2 ) == 4
         assert f.puissance ( 2, -2 ) == 0.25
