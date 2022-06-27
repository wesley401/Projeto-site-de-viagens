programa {
    inteiro valorDesconto,valorProduto,resultado
    cadeia login [5],email[5],senha[5]
	funcao inicio() {
	    criaPerfil()
	    escrevaLinha()
	    validaCadastro()
	    escrevaLinha()
		aplicaDesconto()
	}
	funcao criaPerfil(){
	    escreva("Crie seu Perfil!!")
	    escreva("\nDigite seu nome:")
	    leia (login[0])
	    escreva("Digite seu email:")
	    leia (email[0])
	    escreva("Digite uma senha:")
	    leia(senha[0])
	}
	funcao validaCadastro(){
	    escreva("Faca Login !!")
	    escreva("\ndigite seu email:")
	    leia(email[1])
	    escreva("digite sua senha:")
	    leia(senha[1])
	    se (email[0] == email[1] e senha[0] == senha[1] ){
	        escreva("login efetuado com sucesso !!")
	    }senao {
	        escreva("Senha ou login errados !!")
	    }
	}
	funcao aplicaDesconto(){
	    escreva("Faca suas compras!!")
	    escreva ("\nQual o valor do produto?")
	    leia (valorProduto)
	    escreva ("Qual o valor do desconto?")
		leia (valorDesconto)
		resultado = valorProduto - (valorDesconto * valorProduto / 100) 
		escreva ("Seu desconto foi de:", resultado)
	}
	funcao escrevaLinha(){
	     escreva("\n--------------------------------------------\n")
	}
}
