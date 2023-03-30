'use strict';

/**
 * privilege service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::privilege.privilege');
