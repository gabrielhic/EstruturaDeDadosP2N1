public class Conversor {
  public static String conversao(String infixa) {
    String pos = "";
    Pilha pilha = new Pilha(8);
    int cont = 0;
    char c;

    while (cont < infixa.length()) {
      c = infixa.charAt(cont);
      switch (c) {
        case '*':
        case '/':
        case '+':
        case '-':
        case '^':
          while ((!pilha.isEmpty()) && priority(c) <= priority((char) ((float) pilha.peek())))
            pos += (char) ((float) pilha.pop());

          pilha.push((float) c);
          break;

        case '(':
          pilha.push((float) c);
          break;

        case ')':
          while ((char) ((float) pilha.peek()) != '(')
            pos += (char) ((float) pilha.pop());

          if ((char) ((float) pilha.peek()) == '(')
            pilha.pop();
          break;

        default:
          pos += infixa.charAt(cont);
          break;
      }
      cont++;
    }
    while (pilha.size() > 0)
      if ((char) ((float) pilha.peek()) != '(') {
        pos += (char) ((float) pilha.pop());
        pos += " ";
      } else
        pilha.pop();

    return pos;
  }

  public static int priority(char elemento) {
    int priority;
    switch (elemento) {
      case '+':
      case '-':
        priority = 1;
        break;

      case '*':
      case '/':
        priority = 2;
        break;

      case '^':
        priority = 3;
        break;

      default:
        priority = 0;
        break;
    }

    return priority;
  }
}