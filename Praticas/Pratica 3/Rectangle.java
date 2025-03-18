class Rectangle {
    private Point infEsq;
    private Point supDir;

    Rectangle(int x1,int y1,int x2,int y2) {
	infEsq = new Point(x1, y1);
	supDir = new Point(x2, y2);
    }

    Rectangle(Point p1, Point p2) {
	infEsq = p1;
    supDir = p2;
    }

    public int area() {
	int largura = supDir.x - infEsq.x;
	int altura = supDir.y - infEsq.y;
	return largura * altura;
    }

    public int perimeter() {
	int largura = supDir.x - infEsq.x;
	int altura = supDir.y - infEsq.y;
	return 2*(largura + altura);
    }

    public boolean pointInside(Point p) {
	return p.x >= infEsq.x && p.x <= supDir.x &&
	       p.y >= infEsq.x && p.y <= supDir.y;
    }

    public boolean rectangleInside(Rectangle r) {
	return r.infEsq.x >= infEsq.x && r.supDir.x <= supDir.x &&
	       r.infEsq.y >= infEsq.y && r.supDir.y <= supDir.y;
    }
}