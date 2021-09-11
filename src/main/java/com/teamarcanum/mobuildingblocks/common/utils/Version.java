package com.teamarcanum.mobuildingblocks.common.utils;

import org.apache.maven.artifact.versioning.ArtifactVersion;

public class Version {

    public int major;
    public int minor;
    public int build;

    public Version(ArtifactVersion _version) {

        this(_version.getMajorVersion(), _version.getMinorVersion(), _version.getBuildNumber());
    }

    public Version(int _major, int _minor, int _build) {

        this.major = _major;
        this.minor = _minor;
        this.build = _build;
    }

    @Override
    public int hashCode() {

        return this.major + this.minor + this.build;
    }

    @Override
    public String toString() {

        return this.major + "." + this.minor + "." + this.build;
    }
}
