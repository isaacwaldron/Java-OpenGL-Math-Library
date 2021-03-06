/*
 * (C) Copyright 2015 Richard Greenlees
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 *  1) The above copyright notice and this permission notice shall be included
 *     in all copies or substantial portions of the Software.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package com.joml.vector;

import com.joml.matrix.Matrix3d;
import com.joml.matrix.Matrix3f;
import com.joml.matrix.Matrix4d;
import com.joml.matrix.Matrix4f;

/**
 * Vector3d
 *
 * Contains the definition of a Vector comprising 3 doubles and associated
 * transformations.
 *
 * @author Richard Greenlees
 */
public class Vector3d {

    public double x;
    public double y;
    public double z;

    public static Vector3d forward = new Vector3d(0, 0, 1);
    public static Vector3d up = new Vector3d(0, 1, 0);

    public Vector3d() {

    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3d(Vector3f clone) {
        this.x = clone.x;
        this.y = clone.y;
        this.z = clone.z;
    }

    public Vector3d(Vector3d clone) {
        this.x = clone.x;
        this.y = clone.y;
        this.z = clone.z;
    }

    /**
     * Sets the x, y and z attributes to match the supplied vector
     */
    public void set(Vector3d v) {
        x = v.x;
        y = v.y;
        z = v.z;
    }

    /**
     * Sets the x, y and z attributes to match the supplied vector
     */
    public void set(Vector3f v) {
        x = v.x;
        y = v.y;
        z = v.z;
    }

    /**
     * Sets the x, y and z attributes to the supplied float values
     */
    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Subtracts the supplied vector from this one
     */
    public void sub(Vector3d v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
    }

    /**
     * Subtracts the supplied vector from this one
     */
    public void sub(Vector3f v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
    }

    /**
     * Subtracts v2 from v1 and stores the results in dest. Does not modify v1
     * or v2
     */
    public static void sub(Vector3d v1, Vector3d v2, Vector3d dest) {
        dest.set(v1.x - v2.x,
                v1.y - v2.y,
                v1.z - v2.z);
    }

    /**
     * Subtracts v2 from v1 and stores the results in dest. Does not modify v1
     * or v2
     */
    public static void sub(Vector3d v1, Vector3f v2, Vector3d dest) {
        dest.set(v1.x - v2.x,
                v1.y - v2.y,
                v1.z - v2.z);
    }

    /**
     * Subtracts v2 from v1 and stores the results in dest. Does not modify v1
     * or v2
     */
    public static void sub(Vector3f v1, Vector3d v2, Vector3d dest) {
        dest.set(v1.x - v2.x,
                v1.y - v2.y,
                v1.z - v2.z);
    }

    /**
     * Adds the supplied vector to this one
     */
    public void add(Vector3d v) {
        x += v.x;
        y += v.y;
        z += v.z;
    }

    /**
     * Adds the supplied vector to this one
     */
    public void add(Vector3f v) {
        x += v.x;
        y += v.y;
        z += v.z;
    }

    /**
     * Adds v2 to v1 and stores the results in dest. Does not modify v1 or v2
     */
    public static void add(Vector3d v1, Vector3d v2, Vector3d dest) {
        dest.set(v1.x + v2.x,
                v1.y + v2.y,
                v1.z + v2.z);
    }

    /**
     * Adds v2 to v1 and stores the results in dest. Does not modify v1 or v2
     */
    public static void add(Vector3d v1, Vector3f v2, Vector3d dest) {
        dest.set(v1.x + v2.x,
                v1.y + v2.y,
                v1.z + v2.z);
    }

    /**
     * Adds v2 to v1 and stores the results in dest. Does not modify v1 or v2
     */
    public static void add(Vector3f v1, Vector3d v2, Vector3d dest) {
        dest.set(v1.x + v2.x,
                v1.y + v2.y,
                v1.z + v2.z);
    }

    /**
     * Multiply this Vector3d by another Vector3d
     */
    public void mul(Vector3d v) {
        x *= v.x;
        y *= v.y;
        z *= v.z;
    }

    /**
     * Multiply this Vector3d by another Vector3f
     */
    public void mul(Vector3f v) {
        x *= v.x;
        y *= v.y;
        z *= v.z;
    }

    /**
     * Multiply v1 by v2 and store the results into dest. v1 and v2 are not
     * modified
     * <B>This is not alias safe so make sure dest is not the same as the left
     * or right parameters or you WILL get incorrect results!</B>
     */
    public static void mulFast(Vector3d v1, Vector3d v2, Vector3d dest) {
        dest.x = v1.x * v2.x;
        dest.y = v1.y * v2.y;
        dest.z = v1.z * v2.z;
    }

    /**
     * Multiply this Vector3d by the given rotation matrix mat
     */
    public void mul(Matrix4f mat) {
        set(mat.m00 * x + mat.m10 * y + mat.m20 * z,
                mat.m01 * x + mat.m11 * y + mat.m21 * z,
                mat.m02 * x + mat.m12 * y + mat.m22 * z);
    }

    /**
     * Multiply this Vector3d by the given rotation matrix mat
     */
    public void mul(Matrix4d mat) {
        set(mat.m00 * x + mat.m10 * y + mat.m20 * z,
                mat.m01 * x + mat.m11 * y + mat.m21 * z,
                mat.m02 * x + mat.m12 * y + mat.m22 * z);
    }

    /**
     * Multiply Vector3d v by the given rotation matrix mat and store the
     * results in dest. Does not modify v
     */
    public static void mul(Vector3d v, Matrix4f mat, Vector3d dest) {
        dest.set(mat.m00 * v.x + mat.m10 * v.y + mat.m20 * v.z,
                mat.m01 * v.x + mat.m11 * v.y + mat.m21 * v.z,
                mat.m02 * v.x + mat.m12 * v.y + mat.m22 * v.z);
    }

    /**
     * Multiply Vector3d v by the given rotation matrix mat and store the
     * results in dest. Does not modify v
     */
    public static void mul(Vector3d v, Matrix4d mat, Vector3d dest) {
        dest.set(mat.m00 * v.x + mat.m10 * v.y + mat.m20 * v.z,
                mat.m01 * v.x + mat.m11 * v.y + mat.m21 * v.z,
                mat.m02 * v.x + mat.m12 * v.y + mat.m22 * v.z);
    }

    /**
     * Multiply Vector3d v by the given rotation matrix mat and store the
     * results in dest. Does not modify v
     * <B>This is not alias safe so make sure dest is not the same as the left
     * or right parameters or you WILL get incorrect results!</B>
     */
    public static void mulFast(Vector3d v, Matrix4d mat, Vector3d dest) {
        dest.x = mat.m00 * v.x + mat.m10 * v.y + mat.m20 * v.z;
        dest.y = mat.m01 * v.x + mat.m11 * v.y + mat.m21 * v.z;
        dest.z = mat.m02 * v.x + mat.m12 * v.y + mat.m22 * v.z;
    }

    /**
     * Multiply Vector3d v by the given rotation matrix mat and store the
     * results in dest. Does not modify v
     * <B>This is not alias safe so make sure dest is not the same as the left
     * or right parameters or you WILL get incorrect results!</B>
     */
    public static void mulFast(Vector3d v, Matrix4f mat, Vector3d dest) {
        dest.x = mat.m00 * v.x + mat.m10 * v.y + mat.m20 * v.z;
        dest.y = mat.m01 * v.x + mat.m11 * v.y + mat.m21 * v.z;
        dest.z = mat.m02 * v.x + mat.m12 * v.y + mat.m22 * v.z;
    }

    /**
     * Multiply this Vector3d by the given rotation matrix mat
     */
    public void mul(Matrix3f mat) {
        set(mat.m00 * x + mat.m10 * y + mat.m20 * z,
                mat.m01 * x + mat.m11 * y + mat.m21 * z,
                mat.m02 * x + mat.m12 * y + mat.m22 * z);
    }

    /**
     * Multiply this Vector3d by the given rotation matrix mat
     */
    public void mul(Matrix3d mat) {
        set(mat.m00 * x + mat.m10 * y + mat.m20 * z,
                mat.m01 * x + mat.m11 * y + mat.m21 * z,
                mat.m02 * x + mat.m12 * y + mat.m22 * z);
    }

    /**
     * Multiply Vector3d v by the given rotation matrix mat and store the
     * results in dest. Does not modify v
     */
    public static void mul(Vector3d v, Matrix3f mat, Vector3d dest) {
        dest.set(mat.m00 * v.x + mat.m10 * v.y + mat.m20 * v.z,
                mat.m01 * v.x + mat.m11 * v.y + mat.m21 * v.z,
                mat.m02 * v.x + mat.m12 * v.y + mat.m22 * v.z);
    }

    /**
     * Multiply Vector3d v by the given rotation matrix mat and store the
     * results in dest. Does not modify v
     */
    public static void mul(Vector3d v, Matrix3d mat, Vector3d dest) {
        dest.set(mat.m00 * v.x + mat.m10 * v.y + mat.m20 * v.z,
                mat.m01 * v.x + mat.m11 * v.y + mat.m21 * v.z,
                mat.m02 * v.x + mat.m12 * v.y + mat.m22 * v.z);
    }

    /**
     * Multiply Vector3d v by the given rotation matrix mat and store the
     * results in dest. Does not modify v
     * <B>This is not alias safe so make sure dest is not the same as the left
     * or right parameters or you WILL get incorrect results!</B>
     */
    public static void mulFast(Vector3d v, Matrix3f mat, Vector3d dest) {
        dest.x = mat.m00 * v.x + mat.m10 * v.y + mat.m20 * v.z;
        dest.y = mat.m01 * v.x + mat.m11 * v.y + mat.m21 * v.z;
        dest.z = mat.m02 * v.x + mat.m12 * v.y + mat.m22 * v.z;
    }

    /**
     * Multiply Vector3d v by the given rotation matrix mat and store the
     * results in dest. Does not modify v
     * <B>This is not alias safe so make sure dest is not the same as the left
     * or right parameters or you WILL get incorrect results!</B>
     */
    public static void mulFast(Vector3d v, Matrix3d mat, Vector3d dest) {
        dest.x = mat.m00 * v.x + mat.m10 * v.y + mat.m20 * v.z;
        dest.y = mat.m01 * v.x + mat.m11 * v.y + mat.m21 * v.z;
        dest.z = mat.m02 * v.x + mat.m12 * v.y + mat.m22 * v.z;
    }

    /**
     * Multiply this Vector3d by the given scalar value
     */
    public void mul(double scalar) {
        x *= scalar;
        y *= scalar;
        z *= scalar;
    }

    /* Multiply the given Vector3d v by the scalar value, and store in dest. Does not modify v */
    public static void mul(Vector3d v, double scalar, Vector3d dest) {
        dest.x = v.x * scalar;
        dest.y = v.y * scalar;
        dest.z = v.z * scalar;
    }

    /* Multiply the given Vector3f v by the scalar value, and store in dest. Does not modify v */
    public static void mul(Vector3f v, double scalar, Vector3d dest) {
        dest.x = v.x * scalar;
        dest.y = v.y * scalar;
        dest.z = v.z * scalar;
    }

    /**
     * Returns the length squared of this vector
     */
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    /**
     * Returns the length of this vector
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * Used internally for the distance function
     */
    private static double lengthSquared(Vector3d source) {
        return source.x * source.x + source.y * source.y + source.z * source.z;
    }

    /**
     * Used internally for the distance function
     */
    private static double length(Vector3d source) {
        return Math.sqrt(lengthSquared(source));
    }

    /**
     * Normalizes this vector
     */
    public void normalize() {
        double d = length();
        x /= d;
        y /= d;
        z /= d;
    }

    /**
     * Normalize the original vector and store the results in dest. Does not
     * modify the original
     */
    public static void normalize(Vector3d original, Vector3d dest) {
        double d = length(original);
        dest.set(original.x / d,
                original.y / d,
                original.z / d);
    }

    /**
     * Set this vector to be the cross of v1 and v2
     */
    public void cross(Vector3d v1, Vector3d v2) {
        set(v1.y * v2.z - v1.z * v2.y,
                v1.z * v2.x - v1.x * v2.z,
                v1.x * v2.y - v1.y * v2.x);
    }

    /**
     * Calculate the cross of v1 and v2 and store the results in dest. Does
     * modify v1 or v2
     */
    public static void cross(Vector3d v1, Vector3d v2, Vector3d dest) {
        dest.set(v1.y * v2.z - v1.z * v2.y,
                v1.z * v2.x - v1.x * v2.z,
                v1.x * v2.y - v1.y * v2.x);
    }

    /**
     * Returns the distance between the start and end vectors. Does not modify
     * either
     */
    public static double distance(Vector3d start, Vector3d end) {
        return Math.sqrt((end.x - start.x) * (end.x - start.x)
                + (end.y - start.y) * (end.y - start.y)
                + (end.z - start.z) * (end.z - start.z));
    }
    
    /**
     * Returns the distance between this Vector and v. Does not modify
     * either
     */
    public double distance(Vector3d v) {
        return Math.sqrt((v.x - this.x) * (v.x - this.x)
                + (v.y - this.y) * (v.y - this.y)
                + (v.z - this.z) * (v.z - this.z));
    }

    /**
     * Return the dot product of the supplied v1 and v2 vectors
     */
    public static double dot(Vector3d v1, Vector3d v2) {
        return (v1.x * v2.x) + (v1.y * v2.y) + (v1.z * v2.z);
    }

    public String toString() {
        return "Vector3d { " + x + ", " + y + ", " + z + " }";
    }

}
