package org.ssa.ironyard.controller;

public interface DomainObject extends Cloneable
{
    default boolean isLoaded() {
        return false;

        }

        default int getId() {
        return -1;
        }

        default boolean deeplyEquals(DomainObject other) {
        if (!this.isLoaded() || !other.isLoaded())
            return false;
        if (this.getId() != other.getId())
            return false;
        return true;

        }

}
