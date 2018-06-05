package com.firebase.geofire.util;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;

public final class GeoUtils {
    private static final double MAX_SUPPORTED_RADIUS = 8587.0d;

    public static double distanceToLatitudeDegrees(double d) {
        return d / Constants.METERS_PER_DEGREE_LATITUDE;
    }

    public static double wrapLongitude(double d) {
        if (d >= -180.0d && d <= 180.0d) {
            return d;
        }
        d += 180.0d;
        return d > 0.0d ? (d % 360.0d) - 180.0d : 180.0d - ((-d) % 360.0d);
    }

    private GeoUtils() {
        throw new AssertionError("No instances.");
    }

    public static double distance(GeoLocation geoLocation, GeoLocation geoLocation2) {
        return distance(geoLocation.latitude, geoLocation.longitude, geoLocation2.latitude, geoLocation2.longitude);
    }

    public static double distance(double d, double d2, double d3, double d4) {
        double toRadians = Math.toRadians(d - d3);
        toRadians /= 2.0d;
        d2 = Math.toRadians(d2 - d4) / 2.0d;
        double sin = (Math.sin(toRadians) * Math.sin(toRadians)) + (((Math.cos(Math.toRadians(d)) * Math.cos(Math.toRadians(d3))) * Math.sin(d2)) * Math.sin(d2));
        return 1.27359893E7d * Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin));
    }

    public static double distanceToLongitudeDegrees(double d, double d2) {
        d2 = Math.toRadians(d2);
        double cos = (((Math.cos(d2) * Constants.EARTH_EQ_RADIUS) * 3.141592653589793d) / 180.0d) * (1.0d / Math.sqrt(1.0d - ((Constants.EARTH_E2 * Math.sin(d2)) * Math.sin(d2))));
        if (cos >= Constants.EPSILON) {
            return Math.min(360.0d, d / cos);
        }
        if (d > 0.0d) {
            d = 360.0d;
        }
        return d;
    }

    public static double capRadius(double d) {
        if (d <= MAX_SUPPORTED_RADIUS) {
            return d;
        }
        GeoFire.LOGGER.warning("The radius is bigger than 8587.0 and hence we'll use that value");
        return MAX_SUPPORTED_RADIUS;
    }
}
