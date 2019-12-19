package t.z.h.test;

public class EuclideanDistance {
	/**
	 * 两个向量可以为任意维度，但必须保持维度相同，表示n维度中的两点    
	 * 欧式距离     
	 * 
	 * @param vector1
	 * @param vector2     
	 * @return 两点间距离     
	 */
	public double sim_distance(double[] vector1, double[] vector2) {
		double distance = 0;

		if (vector1.length == vector2.length) {
			for (int i = 0; i < vector1.length; i++) {
				double temp = Math.pow((vector1[i] - vector2[i]), 2);
				distance += temp;
			}
			distance = Math.sqrt(distance);
		}
		return distance;
	}

	// 向量a与矩阵的欧式距离--------------------------------------------------------------------
	public double[] jsim_distance(double[] vector1, double[][] vector2) {
		double distance[] = new double[vector2.length];

		if (vector1.length == vector2[0].length) {
			for (int i = 0; i < vector1.length; i++) {
				for (int j = 0; j < vector2.length; j++) {
					distance[j] += Math.pow((vector1[i] - vector2[i][j]), 2);

				}
			}
		}
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Math.sqrt(distance[i]);
		}
		return distance;
	}

	// 标准化欧式距离-------------------------------------------------------------
	public double[] bzsim_distance(double[] vector1, double[][] vector2) {
		double[] s = new double[vector2.length + 1];
		double[] avg = new double[vector2.length];
		// vector2均值
		for (int i = 0; i < vector2.length; i++) {
			for (int j = 0; j < vector2[0].length; j++) {
				avg[i] += vector2[i][j];
			}
		}
		// vector1均值
		double avg0 = 0;
		for (int i = 0; i < vector1.length; i++) {
			avg0 += vector1[i];
		}
		// vector1方差
		if (vector1.length == vector2[0].length) {
			for (int i = 0; i < vector1.length; i++) {
				s[0] += Math.pow(vector1[i] - avg0, 2);
			}
			s[0] = Math.sqrt(s[0] / vector2.length);
		}
		// vector2方差 
		for (int i = 0; i < vector2.length; i++) {
			for (int j = 0; j < vector2[0].length; j++) {
				s[i + 1] += Math.pow(vector2[i][j] - avg[i], 2);

			}
			s[i + 1] = Math.sqrt(s[i] / vector2.length);
		}

		// 标准化欧氏距离
		double distance[] = new double[vector2.length];
		for (int i = 0; i < vector1.length; i++) {
			for (int j = 0; j < vector2.length; j++) {
				double temp = Math.pow((vector1[i] - vector2[j][i]), 2) / s[i];
				distance[j] = distance[j] + temp;
			}
		}
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Math.sqrt(distance[i]);
		}
		return distance;
	}

	public static void main(String[] args) {
		EuclideanDistance s1 = new EuclideanDistance();
		double[] a = { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,22,1,24,1,1,1,1,29,1,31,1,1,1,35,1,1,1,4,1,1,1,1,1,1,11,1 };
		double[] b = { 2,2,2,2,2,2,2,2,2,2,2,2,2,2,15,2,2,2,2,2,2,22,2,1,2,2,2,2,1,2,31,2,2,34,35,2,2,2,1,5,2,2,2,2,2,1,12 };
		double[] b2 = { 3,3,3,4,3,3,3,3,3,3,3,3,3,3,1,3,3,18,3,3,3,1,23,2,3,3,3,3,2,3,1,32,3,1,1,1,3,3,2,1,6,3,3,3,3,2,1 };
		double[] b3 = { 4,4,1,1,4,6,4,4,4,10,4,4,4,4,2,16,17,1,4,4,4,2,1,3,25,4,4,4,3,4,2,1,4,2,2,1,2,4,4,2,1,4,4,4,4,3,2 };
		double[] b4 = { 1,5,2,2,5,1,5,5,9,1,5,5,5,5,3,1,1,2,19,20,5,3,2,4,1,5,5,5,4,30,3,2,5,3,3,2,2,5,1,3,2,5,5,5,5,11,3 };
		
		double[] c = { 22,24,29,31,35,4,11 };
		double[] d = { 15,22,31,34,35,5,12 };
		double[] e = { 3,4,18,23,32,1,6 };
		double[] f = { 6,10,16,17,25,2,4 };
		double[] g = { 1,9,19,20,30,2,11 };
		System.out.println("普通欧氏距离: \n" + s1.sim_distance(a, b));
		System.out.println("普通欧氏距离: \n" + s1.sim_distance(b, b2));
		System.out.println("普通欧氏距离: \n" + s1.sim_distance(b2, b3));
		System.out.println("普通欧氏距离: \n" + s1.sim_distance(b3, b4));
		
		System.out.println("普通欧氏距离: \n" + s1.sim_distance(c, d));
		System.out.println("普通欧氏距离: \n" + s1.sim_distance(d, e));
		System.out.println("普通欧氏距离: \n" + s1.sim_distance(e, f));
		System.out.println("普通欧氏距离: \n" + s1.sim_distance(f, g));
		// 向量a与矩阵的欧式距离
//		double[][] c = { { 1, 5, 1 }, { 2, 7, 1 }, { 1, 1, 1 } };
//		double[] distance = s1.jsim_distance(a, c);
//		System.out.println("矩阵欧氏距离: ");
//		for (int i = 0; i < distance.length; i++) {
//			System.out.println(distance[i]);
//		}
//		// 向量a与矩阵的标准欧式距离
//		double[] bzsim_distance = s1.bzsim_distance(a, c);
//		System.out.println("标准欧氏距离: ");
//		for (int i = 0; i < bzsim_distance.length; i++) {
//			System.out.println(bzsim_distance[i]);
//		}
	}
}
